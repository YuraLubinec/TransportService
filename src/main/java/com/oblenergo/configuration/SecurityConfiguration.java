package com.oblenergo.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.authorizeRequests().antMatchers("/", "/login").permitAll().antMatchers("/admin/**")
                .access("hasAuthority('ADMIN')").antMatchers("/cashier/**").access("hasAuthority('CASHIER')")
                .antMatchers("/**").access("isAuthenticated()").and().formLogin().loginPage("/login")
                .loginProcessingUrl("/loginCheck").usernameParameter("username").passwordParameter("password")
                .successHandler(authenticationHandler()).failureUrl("/login?error=true").and().exceptionHandling()
                .accessDeniedPage("/403").and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
        // auth.inMemoryAuthentication().withUser("user").password("user").authorities("USER");
        // auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("ADMIN");
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("SELECT username, password, 1 FROM users WHERE username = ?")
                .authoritiesByUsernameQuery("SELECT username, role FROM users WHERE username = ?");
    }

    @Bean
    public AuthenticationHandler authenticationHandler() {
        
        return new AuthenticationHandler();
    }
}
