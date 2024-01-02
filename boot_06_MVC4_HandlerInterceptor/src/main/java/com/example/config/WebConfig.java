package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.interceptor.MyHandlerInterceptor;


@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	MyHandlerInterceptor xxx;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(xxx)
				.addPathPatterns("/login","/mypage");
	}
}
