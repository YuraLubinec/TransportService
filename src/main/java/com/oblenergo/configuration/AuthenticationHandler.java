package com.oblenergo.configuration;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthenticationHandler implements AuthenticationSuccessHandler {

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  public RedirectStrategy getRedirectStrategy() {
    return redirectStrategy;
  }

  public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
    this.redirectStrategy = redirectStrategy;
  }

  @Override
  public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication) throws IOException, ServletException {

    handle(request, response, authentication);
    clearAuthenticationAttributes(request);

  }

  private void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
      throws IOException, ServletException {
    String targetUrl = determineTargetUrl(authentication);
    if (response.isCommitted()) {
      return;
    }
    redirectStrategy.sendRedirect(request, response, targetUrl);
  }

  private String determineTargetUrl(Authentication authentication) {

    boolean isCashier = false;
    boolean isAdmin = false;
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    for (GrantedAuthority grantedAuthority : authorities) {
      if (grantedAuthority.getAuthority().equals("CASHIER")) {
        isCashier = true;
        break;
      } else if (grantedAuthority.getAuthority().equals("ADMIN")) {
        isAdmin = true;
        break;
      }
    }
    if (isCashier) {
      return "/cashier";
    } else if (isAdmin) {
      return "/admin/order";
    } else {
      throw new IllegalStateException();
    }
  }

  private void clearAuthenticationAttributes(HttpServletRequest request) {

    HttpSession session = request.getSession(false);
    if (session == null) {
      return;
    }
    session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
  }

}
