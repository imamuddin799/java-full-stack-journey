package oop_concepts_08.relationship_04.is_a_relation_02.nov_09.assignments;

public class Flower01 {

	String name;
	String color;
	String fragrance;
	boolean isBlooming;

	// Flower(String name, String color, String fragrance, boolean isBlooming){
	// this.name = name;
	// this.color = color;
	// this.fragrance = fragrance;
	// this.isBlooming = isBlooming;
	// }

	public void display() {
		String bloomingStatus = isBlooming ? "Blooming" : "Not Blooming";
		System.out.println("Flower : " + name + ", Color : " + color + ", Fragrance : " + fragrance + " and Status : "
				+ bloomingStatus);
	}

	public void grow() {
		System.out.println("The " + color + " " + name + " is growing taller and stronger.");
	}

	public void bloom() {
		if (isBlooming)
			System.out.println("The " + color + " " + name + " has started blooming!");
		else
			wither();
	}

	public void wither() {
		if (isBlooming != true)
			System.out.println("The " + color + " " + name + " is wilting and no longer blooming.");
		else
			bloom();
	}
}
