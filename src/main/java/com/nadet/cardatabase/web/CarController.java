package com.nadet.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nadet.cardatabase.domain.Car;
import com.nadet.cardatabase.domain.CarRepository;

@RestController
public class CarController {
	@Autowired
	private CarRepository repository;
	
	@RequestMapping(value ="/cars", method=RequestMethod.GET)
	public Iterable<Car> getCars() {
		//Fetch and return cars
		return repository.findAll();
	}

}
