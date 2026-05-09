package oop_concepts_08.basic_oop_01.oct_29;

public class Student05 {

	String name;
	int id;
	double marks;
	String branch;
	String gender;
	int age;

	public void details() {
		System.out.println("Name : " + name + "\nID : " + id + "\nMarks : " + marks + "\nBranch : " + branch
				+ "\nGender : " + gender + "\nAge : " + age);
	}

	public void attendingClass() {
		System.out.println("Student attending the class");
	}

	public void studying() {
		System.out.println("Studying 2 mins and then sleeping........zzzzzzzz");
	}

	public void goingHome() {
		System.out.println("Going home with full excitement");
	}

	public void sleeping() {
		System.out.println("Chatting and then Sleeping");
	}
}
