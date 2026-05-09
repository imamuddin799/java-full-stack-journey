package oop_concepts_08.relationship_04.is_a_relation_02.nov_09;

public class Garage03 {

	public static void main(String[] args) {
		Car02 car = new Car02();
		car.brand = "Maruthi Suzuki";
		car.wheelType = "tyres";
		car.tyres = 4;
		car.fuelType = "Diesel";
		car.lights = 6;
		car.seats = 5;
		car.move();
		car.steeringLeft();
		car.steeringRight();
		car.breaks();
	}
}
