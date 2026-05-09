package methods_03.oct_07;

public class AreaUsingFormalArguments01 {

	// DATE-07/10/2024

	// WAP TO FIND AREA OF SQUARE, RECTANGLE, CIRCLE AND TRIANGLE USING FORMAL
	// ARGUMENTS

	public static void main(String[] args) {
		areaOfSquare(5);
		areaOfRectangle(6, 7);
		areaOfCircle(10);
		areaOfTriangle(8, 9);
	}

	public static void areaOfSquare(int side) {
		int areaOfSquare = side * side;
		System.out.println("Area Of Square : " + areaOfSquare);
	}

	public static void areaOfRectangle(int legnth, int breadth) {
		int areaOfRectangle = legnth * breadth;
		System.out.println("Area Of Rectangle : " + areaOfRectangle);
	}

	public static void areaOfCircle(double r) {
		double pi = 3.14;
		double areaOfCircle = pi * r * r;
		System.out.println("Area Of Circle : " + areaOfCircle);
	}

	public static void areaOfTriangle(double height, double base) {
		double areaOfTriangle = 0.5 * height * base;
		System.out.println("Area Of Triangle : " + areaOfTriangle);
	}
}
