package com.example.CoffeeTea.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Coffee {
	
	@Id
	private int id;
	private String name;
	private double weight, price;
	private int roastLevel;
	
	public Coffee(int id, String name, double weight, double price, int roastLevel) {
		this.id = id;
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.roastLevel = roastLevel;
	}
	
	public Coffee(String name, double weight, double price, int roastLevel) {
		this.name = name;
		this.weight = weight;
		this.price = price;
		this.roastLevel = roastLevel;
	}
	
	public Coffee() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRoastLevel() {
		return roastLevel;
	}

	public void setRoastLevel(int roastLevel) {
		this.roastLevel = roastLevel;
	}
}
