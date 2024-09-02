package com.sena.sheduler.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig {
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")//Permite CORS para todas las rutas
				        .allowedOrigins("http://127.0.0.1:5501")//Origen permitido
				        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				        .allowedHeaders("*")
				        .allowCredentials(true);
			}
		};
		
	}
}