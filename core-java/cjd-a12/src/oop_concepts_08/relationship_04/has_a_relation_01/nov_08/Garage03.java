package oop_concepts_08.relationship_04.has_a_relation_01.nov_08;

public class Garage03 {

	public static void main(String[] args) {
		Bike02 bike = new Bike02("Hero", "Teal", 150000, new Engine01(45, 20, 70, "BS6"));
		System.out.println(bike.brand);
		System.out.println(bike.color);
		System.out.println(bike.cost);
		System.out.println(bike.engine.hp);
		System.out.println(bike.engine.torque);
		System.out.println(bike.engine.milage);
		System.out.println(bike.engine.type);
	}
}
