package basics_01.operators_02;

public class Perimeter11 {

	public static void main(String[] args) {
		// DATE-09/09/2024

		// PERIMETER OF SQUARE
		double side = 10;
		double perimeterOfSquare = 4 * side;
		System.out.println("Perimeter Of Square : " + perimeterOfSquare);

		// PERIMETER OF RECTANGLE
		double length = 20, width = 15;
		double perimeterOfRactangle = 2 * (length + width);
		System.out.println("Perimeter Of Rectangle : " + perimeterOfRactangle);

		// PERIMETER OF TRIANGLE
		double a = 30, b = 40, c = 45;
		double perimeterOfTriangle = a + b + c;
		System.out.println("Perimeter Of Triangle : " + perimeterOfTriangle);

		// PERIMETER OF CIRCLE
		double pi = 3.14, r = 7;
		double perimeterOfCircle = 2 * pi * r;
		System.out.println("Perimeter Of Circle : " + perimeterOfCircle);
	}
}
