package com.jrp.pma.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
/**
	private final DataSource dataSource;
	
	@Autowired
	BCryptPasswordEncoder bCryptEncoder;

	public SecurityConfiguration(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/", "/register", "/register/save").permitAll()
				//.requestMatchers("/projects/new", "/employees/new").hasRole("ADMIN")
				.anyRequest().authenticated())
				.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {

		JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

		userDetailsManager.setUsersByUsernameQuery(
				"SELECT username, password, enabled" + " FROM user_accounts" + " WHERE username = ?");

		userDetailsManager
				.setAuthoritiesByUsernameQuery("SELECT username, role" + " FROM user_accounts" + " WHERE username = ?");

		return userDetailsManager;
	}
	**/
}
