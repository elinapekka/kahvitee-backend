package com.example.CoffeeTea.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.CoffeeTea.model.Coffee;
import com.example.CoffeeTea.model.CoffeeRepository;
import com.example.CoffeeTea.model.Tea;
import com.example.CoffeeTea.model.TeaRepository;

@Component
public class PopulateDB {
	
	@Autowired
	CoffeeRepository coffeeRepository;
	@Autowired 
	TeaRepository teaRepository;
	
	public void populateCoffeeList() {
		coffeeRepository.deleteAll();
		
	   	try {
			BufferedReader reader = new BufferedReader(new FileReader("kahvilista.txt"));
			String row;
			int id = 0;
			while ((row = reader.readLine()) != null) {
				String[] coffeeRowValues = row.split(";", 4);
				id += 1;
				
				Coffee coffee = new Coffee(
						id,
						coffeeRowValues[0], // name
						Double.parseDouble(coffeeRowValues[1]), // weight
						Double.parseDouble(coffeeRowValues[2]), // price
						Integer.parseInt(coffeeRowValues[3]) // roastlevel
						);

				coffeeRepository.save(coffee);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void populateTeaList() {
		teaRepository.deleteAll();
		
	   	try {
			BufferedReader reader = new BufferedReader(new FileReader("teelista.txt"));
			String row;
			int id = 0;
			while ((row = reader.readLine()) != null) {
				String[] teaRowValues = row.split(";", 3);
				id += 1;
				
				Tea tea = new Tea(
						id,
						teaRowValues[0], // name
						Double.parseDouble(teaRowValues[1]), // weight
						Double.parseDouble(teaRowValues[2]) // price
						);

				teaRepository.save(tea);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
