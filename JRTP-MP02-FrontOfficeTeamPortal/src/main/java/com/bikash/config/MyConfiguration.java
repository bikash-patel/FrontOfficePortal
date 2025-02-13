package com.bikash.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bikash.interceptor.SessionInterceptor;

@Configuration
public class MyConfiguration implements WebMvcConfigurer{
	
	@Autowired
	private SessionInterceptor interceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(interceptor)
				.addPathPatterns("/dashboard","/addenquiry","/viewenquiry","/logout"); //Apply to all this path
	}
	
}
