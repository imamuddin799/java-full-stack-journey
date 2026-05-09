package oop_concepts_08.constructor_02.nov_04.assignments;

public class Student01 {

	String name;
	int id;
	double tenth;
	double twelth;
	double degree;

	Student01(String name, int id, double tenth){
		this.name = name;
		this.id = id;
		this.tenth = tenth;
	}

	Student01(String name, int id, double tenth, double twelth){
		this(name, id, tenth);
		this.twelth = twelth;
	}

	Student01(String name, int id, double tenth, double twelth, double degree){
		this(name, id, tenth, twelth);
		this.degree = degree;
	}

	public void details() {
		System.out.println("Name : " + name);
		System.out.println("ID : " + id);
		System.out.println("Tenth : " + tenth);
		if (twelth != 0.0) {
			System.out.println("Twelth : " + twelth);
		}
		if (degree != 0.0) {
			System.out.println("Degree : " + degree);
		}
		System.out.println();
	}
}
