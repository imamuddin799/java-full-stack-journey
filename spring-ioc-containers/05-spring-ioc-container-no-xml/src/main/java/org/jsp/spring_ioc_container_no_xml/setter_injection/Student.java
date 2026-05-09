package org.jsp.spring_ioc_container_no_xml.setter_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

	String name;
	String address;
	long phone;
	
	Laptop laptop;
	Bag bag;
	
	public String getName() {
		return name;
	}
	
	@Value (value = "Imamuddin")
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	
	@Value (value = "Bihar")
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhone() {
		return phone;
	}
	
	@Value (value = "7033534143")
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public Laptop getLaptop() {
		return laptop;
	}
	
	@Autowired
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	public Bag getBag() {
		return bag;
	}
	
	@Autowired
	public void setBag(Bag bag) {
		this.bag = bag;
	}
}