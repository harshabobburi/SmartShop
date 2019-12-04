package com.cognizant.smart_shop_access.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.smart_shop_access.service.AppUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private static final Logger LOGGER = LoggerFactory.getLogger(SecurityConfig.class);
	@Autowired
	AppUserDetailsService appUserDetailsService;

	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(appUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		LOGGER.info("Start");
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.cors();
		httpSecurity.csrf().disable().httpBasic().and().authorizeRequests()
		.antMatchers("/authentication").hasAnyAuthority("U","A","S")
		.antMatchers("/pendingRegistration").hasAuthority("S")
		.antMatchers("/editUserStatus").hasAuthority("S")
		.antMatchers("/allProducts").hasAnyAuthority("U","A")
		.antMatchers("/addEditProduct").hasAuthority("A")
		.antMatchers("/deleteProduct/{productCode}").hasAuthority("A")
		.antMatchers("/generateBill").hasAuthority("A")
		.anyRequest().authenticated().and().addFilter(new JwtAuthorizationFilter(authenticationManager()));
	}

}