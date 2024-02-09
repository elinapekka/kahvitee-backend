package com.example.CoffeeTea.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CoffeeTea.model.Coffee;
import com.example.CoffeeTea.model.CoffeeRepository;
import com.example.CoffeeTea.utils.PopulateDB;


@RestController
class CoffeeTeaController {
	
	@Autowired
	private CoffeeRepository coffeeRepo;
	@Autowired
	private PopulateDB populateDb;
	
    @PostMapping("/addcoffee")
    public void addCoffee(
    		@RequestParam("name") String name, 
    		@RequestParam("weight") double weight,
    		@RequestParam("price") double price,
    		@RequestParam("roastLevel") int roastLevel
    		) {
        
    	try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("kahvilista.txt", true));
			String input = name + ";" 
					+ weight + ";" 
					+ price + ";"
					+ roastLevel;
			
			writer.append("\n" + input);
			System.out.println(input);
			writer.close();
	    	populateDb.populate();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
 
    }
    
    @DeleteMapping("/deletecoffee")
    public void deleteCoffee(@RequestParam("id") int id) {
			
			coffeeRepo.deleteById(id);
			
			try {
				String input = "";
				List<Coffee> coffees = (List<Coffee>) coffeeRepo.findAll(); 
				
				BufferedWriter writer = new BufferedWriter(new FileWriter("kahvilista.txt"));
				
				for(Coffee coffee: coffees) {
					if(coffee.getId() != 1) {
						input += "\n" + coffee.getName() + ";" + coffee.getWeight() + ";" 
								+ coffee.getPrice() + ";"+ coffee.getRoastLevel() ;
					} else {
						input = coffee.getName() + ";" + coffee.getWeight() + ";" 
								+ coffee.getPrice() + ";" + coffee.getRoastLevel();
						
					}	
				}
				
				writer.write(input);
				writer.close();
				populateDb.populate();

			} catch (IOException e) {
				e.printStackTrace();
			}
			/*
			writer.append("\n" + input);
			System.out.println(input);
			writer.close();
	    	populateDb.populate();
	    	*/
    }
    
    @PostMapping("/addtea")
    public void addTea(
    		@RequestParam("name") String name, 
    		@RequestParam("weight") double weight,
    		@RequestParam("price") double price
    		) {
    	
    	try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("teelista.txt", true));
			String input = name + ";" 
					+ weight + ";" 
					+ price;
			
			writer.append("\n" + input);
			System.out.println(input);
			writer.close();
	    	populateDb.populateTeaList();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
