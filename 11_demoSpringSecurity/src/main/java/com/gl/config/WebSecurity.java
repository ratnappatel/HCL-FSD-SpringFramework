package com.gl.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
			.csrf().disable().authorizeRequests()
			.antMatchers("/admin").hasRole("admin")
			.and().formLogin();
		
	}
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .inMemoryAuthentication().withUser("Gargesh").password("{noop}gargesh@123").roles("user")
            .and().withUser("Ratna").password("{noop}ratna@123").roles("admin");
            
    }
	
	

}
