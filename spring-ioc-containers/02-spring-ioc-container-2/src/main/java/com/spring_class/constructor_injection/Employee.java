package com.spring_class.constructor_injection;

//import java.util.ArrayList;
import java.util.List;

public class Employee {

	private int eid;
	private String ename;
	private String address;
//	private ArrayList<String> skills;
//	public Employee(int eid, String ename, String address, ArrayList<String> skills) {
	private List<String> skills;
	public Employee(int eid, String ename, String address, List<String> skills) {
		super();
		this.eid = eid;
		this.ename = ename;
		this.address = address;
		this.skills = skills;
	}
	
	public void employeeDetails() {
		System.out.println("Eid : "+ eid);
		System.out.println("Ename : "+ ename);
		System.out.println("Address : "+ address);
		int sk = 1;
		for(String skill : skills) {
			System.out.println(sk++ +" "+ skill);
		}
	}
}