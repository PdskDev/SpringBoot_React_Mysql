package com.nadet.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nadet.cardatabase.domain.Car;
import com.nadet.cardatabase.domain.CarRepository;
import com.nadet.cardatabase.domain.Owner;
import com.nadet.cardatabase.domain.OwnerRepository;


@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);
	
	@Autowired
	private CarRepository repository;
	
	@Autowired
	private OwnerRepository orepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application successfully started");
		
	}
	
	@Override
	public void run (String... args) throws Exception {
		//Add owner object
		Owner owner1 = new Owner("Nadet", "LB");
		Owner owner2 = new Owner("Societe", "PDSK");
		orepository.saveAll(Arrays.asList(owner1, owner2));
				
		repository.save(new Car("Ford", "Mustang", "Red", "ADF-1221", 2021, 59000, owner1));
		repository.save(new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2));
		repository.save(new Car("Toyota", "Prius", "Silver", "KKO-0212", 2020, 39000, owner2));
		repository.save(new Car("Peugeot", "508", "Black", "GGO-0520", 2021, 55000, owner1));
		repository.save(new Car("Renault", "Talisman", "Green", "PAR-1550", 2021, 65000, owner2));
		
		//Fetch all cars and log to console
		for (Car car: repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}

}