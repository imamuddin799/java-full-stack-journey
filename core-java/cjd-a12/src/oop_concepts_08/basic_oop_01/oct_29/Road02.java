package oop_concepts_08.basic_oop_01.oct_29;

public class Road02 {

	public static void main(String[] args) {
		Bike01 b = new Bike01();
		b.brand = "Hero";
		b.cost = 100000.00;
		b.color = "Black";
		b.topSpeed = 95;
		b.cc = 97;
		b.milege = 54.5;
		b.tyres = 2;
		b.gears = 4;
		b.ride();
		b.stop();
	}
}
