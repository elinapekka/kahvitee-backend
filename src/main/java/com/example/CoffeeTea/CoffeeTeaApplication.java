package com.example.CoffeeTea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.CoffeeTea.utils.PopulateDB;

@SpringBootApplication
public class CoffeeTeaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoffeeTeaApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner populate(PopulateDB populateDb) {
		return (args) -> {
			populateDb.populateCoffeeList();
			populateDb.populateTeaList();
		};
	}
}
