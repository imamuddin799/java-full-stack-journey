package oop_concepts_08.relationship_04.has_a_relation_01.nov_08.assignment;

public class Pen02 {

	Cap01 cap;
	String color;

	Pen02(String color, Cap01 cap) {
		this.color = color;
		this.cap = cap;
	}

	public void writes() {
		System.out.println("Pen Color : " + color);
		System.out.println("Write java program");
	}
}
