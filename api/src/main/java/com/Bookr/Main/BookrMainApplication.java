package com.Bookr.Main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.Bookr.Controllers", "com.Bookr.Services"})
@EntityScan("com.Bookr.Entities")
@EnableJpaRepositories("com.Bookr.Boundaries")
public class BookrMainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookrMainApplication.class, args);
	}

}
