package oop_concepts_08.basic_oop_01.oct_30;

public class Student03 {

	// Declaring all the variables
	String name;
	int id;
	int english;
	int maths;
	int science;
	int socialScience;
	int totalMarks;
	int percentage;

	// Declaring details method to display all the details
	public void details() {
		System.out.println("Name : " + name);
		System.out.println("Marks in English : " + english);
		System.out.println("Marks in Maths : " + maths);
		System.out.println("Marks in Science : " + science);
		System.out.println("Marks in Social Science : " + socialScience);
		System.out.println("Total Marks : " + totalMarks);
		System.out.println("Marks Percentage : " + percentage);
	}

	// Declaring totalMarks method to find sum of all the subject marks
	public int totalMarks() {
		return english + maths + science + socialScience;
	}

	// Declaring percentage method to find percentage of all the subject's marks
	public int percentage() {
		return (english + maths + science + socialScience) / 4;
	}
}
