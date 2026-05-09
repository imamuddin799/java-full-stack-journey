package oop_concepts_08.relationship_04.has_a_relation_01.nov_08.assignment;

public class Cap01 {

	String color;

	Cap01(String color) {
		this.color = color;
	}

	public void openCap() {
		System.out.println("Cap Color : " + color);
		System.out.println("Cap Opened...");
	}

	public void closeCap() {
		System.out.println("Cap Closed...");
	}
}
