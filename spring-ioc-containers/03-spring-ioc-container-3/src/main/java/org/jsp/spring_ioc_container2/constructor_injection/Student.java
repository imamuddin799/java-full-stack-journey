package org.jsp.spring_ioc_container2.constructor_injection;

public class Student {

	private String name;
	private int rollno;
	private String address;
	private double marks;
	
	private Pen pen;

	public Student(String name, int rollno, String address, double marks, Pen pen) {
		this.name = name;
		this.rollno = rollno;
		this.address = address;
		this.marks = marks;
		this.pen = pen;
	}

	public void studentDetails() {
		System.out.println("Student [ name = " + name + ", rollno = " + rollno + ", address = " + address + ", marks = " + marks + ", pen = "
				+ pen + "]");
	}
}