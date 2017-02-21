package com.oblenergo.validator;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.oblenergo.model.Orders;
import com.oblenergo.service.SapService;

@Component
public class OrderValidator implements Validator {

  @Autowired
  SapService sapServiceImpl;

  @Override
  public boolean supports(Class<?> clazz) {

    return Orders.class.equals(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    String regexPattern = "([1][0-7]):[0-5][0-9]";
    String regexPhoneNumber = "^\\+380([0-9]?){9,11}[0-9]$";
    Orders tn = (Orders) target;
    String tabNumber = tn.getUser_tab();
    String phoneNumber = tn.getMobile_phone_number();
    String time = tn.getTime();
    String timeEnd = tn.getTime_end();

    if (tabNumber != null && tabNumber != "" && tabNumber.length() <= 5) {

      if (!tabNumber.matches("\\d+")) {
        errors.rejectValue("user_tab", "Must.be.number");
      } else {
        String fullName = sapServiceImpl.getFullNameFromSap(tabNumber);
        if (fullName == null || StringUtils.isBlank(fullName)) {
          errors.rejectValue("user_tab", "No.such.tabnamber");
        }
      }
    }

    if (!checkInput(regexPattern, time)) {
      errors.rejectValue("time", "Bad.time");
      return;
    }

    if (!checkInput(regexPattern, timeEnd)) {
      errors.rejectValue("time_end", "Bad.time");

    }

    if (!checkInput(regexPhoneNumber, phoneNumber)) {
      errors.rejectValue("mobile_phone_number", "Bad.phone.number");

    }

  }

  public boolean checkInput(String regex, String input) {
    if (input == null) {
      return false;
    }
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(input);
    if (m.find()) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isAdmin() {
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    boolean isAdmin = false;
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    for (GrantedAuthority grantedAuthority : authorities) {
      if (grantedAuthority.getAuthority().equals("ADMIN")) {
        isAdmin = true;
        break;
      }
    }
    return isAdmin;
  }

}
