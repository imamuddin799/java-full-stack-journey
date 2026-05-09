package oop_concepts_08.relationship_04.is_a_relation_02.nov_09.assignments;

public class Rose02 extends Flower01 {

	String thornSize;
	int bloomPeriod;

	public void bloomPeriod() {
		System.out.println("The blooming period of " + color + " " + name + " is " + bloomPeriod + " months.");
	}

	public void watered() {
		System.out.println("The " + color + " " + name + " is watered");
	}
}