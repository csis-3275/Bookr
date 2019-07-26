package com.Bookr.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 
 * @author Ayodeji Tolu-ojo 300249754
 *
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.Bookr.Controllers", "com.Bookr.Services"})
@EntityScan("com.Bookr.Entities")
@EnableJpaRepositories("com.Bookr.Boundaries")

public class BookrMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookrMainApplication.class, args);
	}
	
	@Bean
	   public WebMvcConfigurer corsConfigurer() {
	      return new WebMvcConfigurer() {
	         @Override
	         public void addCorsMappings(CorsRegistry registry) {
	            registry.addMapping("/api/users").allowedOrigins("http://localhost:3000");
	            registry.addMapping("/api/users/login").allowedOrigins("http://localhost:3000");
	         }
	      };
	   }

}
