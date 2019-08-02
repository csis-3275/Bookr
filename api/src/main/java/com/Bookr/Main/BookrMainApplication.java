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
	            registry.addMapping("/api/users").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/users/all").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/users/all_roles").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/users/{user_id}").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/users/create_user").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/users/login").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/users/delete/{user_id}").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/reservations").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/reservations/all").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/reservations/{reservation_id}").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/reservations/create_reservation").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/rooms").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/rooms/all").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/rooms/{room_id}").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/requests").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/requests/create_request").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/requests/all").allowedOrigins("http://localhost:8000");
	            registry.addMapping("/api/requests/{request_id}").allowedOrigins("http://localhost:8000");
	         }
	      };
	   }

}
