package com.example.shelf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin
public class ShelfApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelfApplication.class, args);
	}

}
