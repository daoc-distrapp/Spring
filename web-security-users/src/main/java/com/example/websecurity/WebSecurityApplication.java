package com.example.websecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@SpringBootApplication
public class WebSecurityApplication implements ApplicationRunner {

	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(WebSecurityApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(!jdbcUserDetailsManager.userExists("user2")) {
			jdbcUserDetailsManager.createUser(User.withUsername("user2").password(passwordEncoder.encode("user2")).roles("USER").build());
		}
		if(!jdbcUserDetailsManager.userExists("admin2")) {
			jdbcUserDetailsManager.createUser(User.withUsername("admin2").password(passwordEncoder.encode("admin2")).roles("ADMIN").build());
		}
	}

}
