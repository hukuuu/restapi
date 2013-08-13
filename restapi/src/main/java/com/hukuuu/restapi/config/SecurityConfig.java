package com.hukuuu.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		System.out.println("configure resources");
		web.ignoring().antMatchers("/resources/**"); // #3
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http
          .authorizeUrls()
              .antMatchers("/**").hasRole("USER").and()
              .httpBasic();
	}

    @Override
    protected void registerAuthentication(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
            .inMemoryAuthentication()
                .withUser("user")
                    .password("password")
                    .roles("USER");
    }
}
