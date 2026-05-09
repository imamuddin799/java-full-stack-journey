package org.jsp.spring_ioc_container_no_xml.inser_into_database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Entity
public class BikeEngine {

	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	
	@Value (value = "TVS")
	private String brand;
	
	@Value (value = "10000.00")
	private double cost;

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}

	public double getCost() {
		return cost;
	}
}