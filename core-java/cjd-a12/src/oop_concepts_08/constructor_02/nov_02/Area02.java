package oop_concepts_08.constructor_02.nov_02;

public class Area02 {

	public static void main(String[] args){
		Circle01 c1 = new Circle01(7);
		double area = c1.area();
		double perimeter = c1.perimeter();
		System.out.println("Area of Circle is : "+ area);
		System.out.println("Perimeter of Circle is : "+ perimeter);
		
		Circle01 c2 = new Circle01(17);
		area = c2.area();
		perimeter = c2.perimeter();
		System.out.println("Area of Circle is : "+ area);
		System.out.println("Perimeter of Circle is : "+ perimeter);
	}
}
