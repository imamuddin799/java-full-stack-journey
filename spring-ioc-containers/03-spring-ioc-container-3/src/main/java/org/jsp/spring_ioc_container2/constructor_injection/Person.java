package org.jsp.spring_ioc_container2.constructor_injection;

import java.util.List;

public class Person {

	private String name;
	private int age;
	private long contact;
	List<String> skills;
	public Person(String name, int age, long contact, List<String> skills) {
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.skills = skills;
	}

	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", contact=" + contact + ", skills=" + skills + "]";
	}
	
	public void personDetails() {
		System.out.println("Name : "+ name +" , Age : "+ age +" , Contact : "+ contact +" , Skills "+ skills);
	}
}