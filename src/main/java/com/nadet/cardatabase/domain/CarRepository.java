package com.nadet.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	//Fetch cars by brand
	List<Car> findByBrand(String brand); 
	
	//Fetch cars by color
	List<Car> findByColor(String color); 
	
	//Fetch cars by year
	List<Car> findByBuildYear(int buildYear); 
	
	//Fetch cars by brand and model
	List<Car> findByBrandAndModel(String brand, String model);
	
	//Fetch cars by brand or color
	List<Car> findByBrandOrColor(String brand, String color);
	
	//Fetch cars by brand and sort par year asc
	List<Car> findByBrandOrderByBuildYearAsc(String brand);
	
	//Fetch cars by brand using SQL
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrandSQL(String brand);
	
	//Fetch cars by brand using SQL Like
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
	
	
}
