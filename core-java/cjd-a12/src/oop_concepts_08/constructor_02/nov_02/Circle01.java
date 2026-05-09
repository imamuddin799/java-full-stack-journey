package oop_concepts_08.constructor_02.nov_02;

public class Circle01 {

	double radius;
	static double pi = 3.14;
	Circle01(double r){
		this.radius = r;
	}
	public double area(){
		return pi*radius*radius;
	}
	public double perimeter(){
		return 2*pi*radius;
	}
}
