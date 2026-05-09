package oop_concepts_08.constructor_02.nov_04.assignments;

public class Boxes04 {

	/**
	 * double length;
	 * double breadth;
	 * double height;
	 */
	public static void main(String[] args) {
		Box03 b1 = new Box03(10.0, 20.0);
		b1.area();

		Box03 b2 = new Box03(10.0, 20.0, 30.0);
		b2.area();
	}
}
