package com.nadet.cardatabase.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Car {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String brand, model, color, registerNumber;
	private int buildYear, price;
	
	public Car() {}
	
	public Car(String brand, String model, String color, 
			String registerNumber, int buildYear, int price, Owner owner) {
		super();
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.registerNumber = registerNumber;
		this.buildYear = buildYear;
		this.price = price;
		this.owner = owner;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRegisterNumber() {
		return registerNumber;
	}

	public void setRegisterNumber(String registerNumber) {
		this.registerNumber = registerNumber;
	}

	public int getBuildYear() {
		return buildYear;
	}

	public void setBuildYear(int buildYear) {
		this.buildYear = buildYear;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//Many to One relationship
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="owner")
	private Owner owner;
	
	public Owner getOwner() {
	return owner;
	}
	
	public void setOwner(Owner owner) {
		this.owner = owner;
	}

}
