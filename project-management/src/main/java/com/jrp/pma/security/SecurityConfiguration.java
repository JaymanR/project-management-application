package com.jrp.pma.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((authorize) -> authorize
				.requestMatchers("/projects/new", "/employees/new")
				.hasRole("ADMIN").requestMatchers("/").authenticated().anyRequest().permitAll())
				.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

		return http.build();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user1 = User.withDefaultPasswordEncoder().username("user").password("password").roles("USER")
				.build();

		UserDetails user2 = User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN")
				.build();

		return new InMemoryUserDetailsManager(user1, user2);
	}
}
