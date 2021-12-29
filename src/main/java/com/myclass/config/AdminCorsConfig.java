package com.myclass.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class AdminCorsConfig {

	@Value("${allowed.origin}")
	private String allowedOrigin;
	@Bean
	public WebMvcConfigurer getCorsConfiggurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/admin/**")
				.allowedOrigins(allowedOrigin)
				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
				.allowedHeaders("*");
				
						
			}

		};
	}
}
