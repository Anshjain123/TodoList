package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;


@CrossOrigin(origins = "http://localhost:4200")
@SpringBootApplication
public class RestfulWebServicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(RestfulWebServicesApplication.class, args);
	}

}
