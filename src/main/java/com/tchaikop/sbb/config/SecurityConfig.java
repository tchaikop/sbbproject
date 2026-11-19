package com.tchaikop.sbb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	//모든 사용자의 접근을 ㅁ든 페이지에 대한 접근을 허가하는 Bean 선언
	@Bean
	   SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	      http
	           .authorizeHttpRequests(authorize -> authorize
	               .anyRequest().permitAll()
	           );
	      
	      return http.build();
	   }

}
