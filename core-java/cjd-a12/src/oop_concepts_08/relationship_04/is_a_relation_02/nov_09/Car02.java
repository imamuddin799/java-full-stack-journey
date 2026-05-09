package oop_concepts_08.relationship_04.is_a_relation_02.nov_09;

public class Car02 extends Vehical01 {

	int seats;
	int tyres;
	String brand;

	public void steeringRight() {
		System.out.println("Right Turn");
	}

	public void steeringLeft() {
		System.out.println("Left Turn");
	}
}