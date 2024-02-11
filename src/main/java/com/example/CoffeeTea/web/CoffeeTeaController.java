package com.example.CoffeeTea.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.CoffeeTea.model.Coffee;
import com.example.CoffeeTea.model.CoffeeRepository;
import com.example.CoffeeTea.model.Tea;
import com.example.CoffeeTea.model.TeaRepository;
import com.example.CoffeeTea.utils.PopulateDB;

@RestController
public class CoffeeTeaController {
	
	@Autowired
	private CoffeeRepository coffeeRepository;
	@Autowired
	private TeaRepository teaRepository;
	@Autowired
	private PopulateDB populateDb;
	
    @PostMapping("/addcoffee")
    public String addCoffee(
    		@RequestParam("name") String name, 
    		@RequestParam("weight") double weight,
    		@RequestParam("price") double price,
    		@RequestParam("roastLevel") int roastLevel
    		) {
        
    	if(name.matches("[0-9a-zA-ZäöåÄÖÅ\\s]+") 
    	&& (weight >= 0) 
    	&& (price >= 0) 
    	&& (roastLevel >= 1 && roastLevel <= 5)) {
	    	try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("kahvilista.txt", true));
				String input = name + ";" 
						+ weight + ";" 
						+ price + ";"
						+ roastLevel;
				
				if(coffeeRepository.count() != 0) {
					writer.append("\n" + input);
				} else {
					writer.append(input);
				}
				
				writer.close();
		    	populateDb.populateCoffeeList();
		    	return "Success";
				
			} catch (IOException e) {
				e.printStackTrace();
				return "Something went wrong";
			}
    	} else {
    		return "Add coffee failed. Check the inputted values.";
    	}
    }
    
    @DeleteMapping("/deletecoffee")
    public void deleteCoffee(@RequestParam("id") int id) {
			
			coffeeRepository.deleteById(id);
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("kahvilista.txt"));
				
				if(coffeeRepository.count() != 0) {
					List<Coffee> coffees = (List<Coffee>) coffeeRepository.findAll(); 
					String input = coffees.get(0).getName()+ ";" 
							+ coffees.get(0).getWeight() + ";" 
							+ coffees.get(0).getPrice() + ";"
							+ coffees.get(0).getRoastLevel();
					
					for(int i = 1; i < coffees.size(); i++) {
						input += "\n" + coffees.get(i).getName() + ";" 
								+ coffees.get(i).getWeight() + ";" 
								+ coffees.get(i).getPrice() + ";"
								+ coffees.get(i).getRoastLevel() ;
					}
					writer.write(input);
					writer.close();
					populateDb.populateCoffeeList();
				} else {
					writer.write("");
					writer.close();
					populateDb.populateCoffeeList();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    @PutMapping("/editcoffee")
    public String editCoffee(
    		@RequestParam("id") int id,
    		@RequestParam("name") String name, 
    		@RequestParam("weight") double weight,
    		@RequestParam("price") double price,
    		@RequestParam("roastLevel") int roastLevel
    		) {
    	
    	if(name.matches("[0-9a-zA-ZäöåÄÖÅ\\s]+") 
    	&& (weight >= 0) 
    	&& (price >= 0) 
    	&& (roastLevel >= 1 && roastLevel <= 5)) {
    		
	    	try {
	    		Coffee coffee = new Coffee(id, name, weight, price, roastLevel);
	    		coffeeRepository.save(coffee);
	    		
	    		List<Coffee> coffees = (List<Coffee>) coffeeRepository.findAll(); 
	    		
				BufferedWriter writer = new BufferedWriter(new FileWriter("kahvilista.txt"));

				String input = coffees.get(0).getName()+ ";" 
						+ coffees.get(0).getWeight() + ";" 
						+ coffees.get(0).getPrice() + ";"
						+ coffees.get(0).getRoastLevel();
				
				for(int i = 1; i < coffees.size(); i++) {
					input += "\n" + coffees.get(i).getName() + ";" 
							+ coffees.get(i).getWeight() + ";" 
							+ coffees.get(i).getPrice() + ";"
							+ coffees.get(i).getRoastLevel() ;
				}
				
				writer.write(input);
				writer.close();
		    	populateDb.populateCoffeeList();
		    	return "Successfully edited";
				
			} catch (IOException e) {
				e.printStackTrace();
				return "Something went wrong";
			}
    	} else {
    		return "Edit coffee failed. Check the inputted values.";
    	}
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
			
			if(teaRepository.count() != 0) {
				writer.append("\n" + input);
			} else {
				writer.append(input);
			}
			writer.close();
	    	populateDb.populateTeaList();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    @DeleteMapping("/deletetea")
    public void deleteTea(@RequestParam("id") int id) {
			
			teaRepository.deleteById(id);
			
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter("teelista.txt"));
				
				if(teaRepository.count() != 0) {
					List<Tea> teas = (List<Tea>) teaRepository.findAll();
					String input = teas.get(0).getName()+ ";" 
							+ teas.get(0).getWeight() + ";" 
							+ teas.get(0).getPrice();
					
					for(int i = 1; i < teas.size(); i++) {
						input += "\n" + teas.get(i).getName() + ";" 
								+ teas.get(i).getWeight() + ";" 
								+ teas.get(i).getPrice();
					}
					
					writer.write(input);
					writer.close();
					populateDb.populateTeaList();
					
				} else {
					writer.write("");
					writer.close();
					populateDb.populateTeaList();
				}

			} catch (IOException e) {
				e.printStackTrace();
			}
    }
    
    @PutMapping("/edittea")
    public String editTea(
    		@RequestParam("id") int id,
    		@RequestParam("name") String name, 
    		@RequestParam("weight") double weight,
    		@RequestParam("price") double price
    		) {
    	
    	if(name.matches("[0-9a-zA-ZäöåÄÖÅ\\s]+") 
    	&& (weight >= 0) 
    	&& (price >= 0)) {
    		
	    	try {
	    		Tea tea = new Tea(id, name, weight, price);
	    		teaRepository.save(tea);
	    		
	    		List<Tea> teas = (List<Tea>) teaRepository.findAll(); 
	    		
				BufferedWriter writer = new BufferedWriter(new FileWriter("teelista.txt"));

				String input = teas.get(0).getName()+ ";" 
						+ teas.get(0).getWeight() + ";" 
						+ teas.get(0).getPrice();
				
				for(int i = 1; i < teas.size(); i++) {
					input += "\n" + teas.get(i).getName() + ";" 
							+ teas.get(i).getWeight() + ";" 
							+ teas.get(i).getPrice();
				}
				
				writer.write(input);
				writer.close();
		    	populateDb.populateTeaList();
		    	return "Successfully edited";
				
			} catch (IOException e) {
				e.printStackTrace();
				return "Something went wrong";
			}
    	} else {
    		return "Edit tea failed. Check the inputted values.";
    	}
    }
}
