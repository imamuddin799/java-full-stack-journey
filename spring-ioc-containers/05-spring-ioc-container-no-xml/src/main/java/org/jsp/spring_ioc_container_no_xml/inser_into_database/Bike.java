package org.jsp.spring_ioc_container_no_xml.inser_into_database;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Entity(name = "bike")
public class Bike {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bike_id")
	private int id;

	@Value(value = "Hero")
	private String brand;

	@Value(value = "Blue")
	private String color;

	@Value(value = "98000.00")
	private double cost;

	@OneToOne(cascade = CascadeType.ALL)
	@Autowired
	private BikeEngine bikeEngine;

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public double getCost() {
		return cost;
	}

	public BikeEngine getBikeEngine() {
		return bikeEngine;
	}
}