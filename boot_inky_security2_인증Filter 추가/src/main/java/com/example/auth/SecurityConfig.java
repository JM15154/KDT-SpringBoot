package com.example.auth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
		
	 @Bean // 객체 생성
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		System.out.println("SecurityConfig.filterChain");
		//허용 여부 결정
		// 허용할 페이지 : /signUp
		http.authorizeRequests().antMatchers("/login","/signup").permitAll().anyRequest().authenticated();
		
		// 로그인 화면 설정
		http
			.formLogin()
				.loginPage("/login")			// 로그인 화면 설정 ==> id와 pw입력
				.loginProcessingUrl("/auth")	// 입력한 id와 pw를 체크할 Spring Security의 Bean
				.usernameParameter("email")
				.passwordParameter("password")
				.defaultSuccessUrl("/");
		
		// 로그아웃
		http
			.logout()
				.logoutUrl("/logout") // 지정된 요청값으로 요청하면 자동으로 로그아웃 해줌
				.logoutSuccessUrl("/"); // 로그아웃 성공  후 가는 URL,
		
		return http.build();
	}
}
