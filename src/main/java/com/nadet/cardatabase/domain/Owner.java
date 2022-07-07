package com.nadet.cardatabase.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
//import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

@Entity
public class Owner {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ownerid;
	private String firstname, lastname;
	
	public Owner() {}

	public Owner(String firstname, String lastname) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public long getOwenerid() {
		return ownerid;
	}

	public void setOwenerid(long owenerid) {
		this.ownerid = owenerid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	//@OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
	name="car_owner", 
	joinColumns = {@JoinColumn(name="owernid")},
	inverseJoinColumns = {@JoinColumn(name="id")})
	
	private Set<Car> cars = new HashSet<Car>();
	
	public Set<Car> getCars() {
		return cars;
	}
	
	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}
}
