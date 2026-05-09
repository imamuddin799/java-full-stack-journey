package org.jsp.onetoone_bi.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Heart {

	@Id
	private int id;
	private int bitsPerMinute;
	private double weight;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "heart")
	Person person;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBitsPerMinute() {
		return bitsPerMinute;
	}

	public void setBitsPerMinute(int bitsPerMinute) {
		this.bitsPerMinute = bitsPerMinute;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString() {
		return "Heart [id = " + id + ", bitsPerMinute = " + bitsPerMinute + ", weight = " + weight + "]";
	}
}