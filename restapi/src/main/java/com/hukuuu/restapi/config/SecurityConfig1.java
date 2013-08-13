package com.hukuuu.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//@Configuration
public class SecurityConfig1 /*extends
   WebSecurityConfigurerAdapter*/ {
//  @Override
//  protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
//    auth
//      .inMemoryAuthentication()
//        .withUser("user")  // #1
//          .password("password")
//          .roles("USER")
//          .and()
//        .withUser("admin") // #2
//          .password("password")
//          .roles("ADMIN","USER");
//  }
// 
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    web
//      .ignoring()
//         .antMatchers("/resources/**"); // #3
//  }
// 
//  @Override
//  protected void configure(HttpSecurity http) throws Exception {
//    http
//      .authorizeUrls()
//        .antMatchers("/signup","/about","/login").permitAll() // #4
//        .antMatchers("/admin/**").hasRole("ADMIN") // #6
//        .anyRequest().authenticated() // 7
//        .and()
//        .httpBasic();
//  }
}
