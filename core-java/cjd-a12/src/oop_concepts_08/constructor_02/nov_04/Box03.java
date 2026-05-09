package oop_concepts_08.constructor_02.nov_04;

public class Box03 {

	double length;
	double breadth;
	double height;

	Box03(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	Box03(double length, double breadth, double height) {
		this.length = length;
		this.breadth = breadth;
		this.height = height;
	}

	public void area() {
		if (height == 0.0) {
			double area = length * breadth;
			System.out.println("Area of the 2D box is " + area);
		} else {
			double volume = length * breadth * height;
			System.out.println("Volume of the 3D box is " + volume);
		}
	}
}
