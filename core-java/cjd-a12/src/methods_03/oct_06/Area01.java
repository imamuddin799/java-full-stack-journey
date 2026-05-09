package methods_03.oct_06;

public class Area01 {

	// DATE-06/10/2024

	// WAP TO FIND AREA OF SQUARE, RECTANGLE, CIRCLE AND TRIANGLE USING METHODS

	public static void main(String[] args) {
		areaOfSquare();
		areaOfRectangle();
		areaOfCircle();
		areaOfTriangle();
	}

	public static void areaOfSquare() {
		int side = 10;
		int areaOfSquare = side * side;
		System.out.println("Area Of Square : " + areaOfSquare);
	}

	public static void areaOfRectangle() {
		int legnth = 20, width = 10;
		int areaOfRectangle = legnth * width;
		System.out.println("Area Of Rectangle : " + areaOfRectangle);
	}

	public static void areaOfCircle() {
		double pi = 3.14, r = 7;
		double areaOfCircle = pi * r * r;
		System.out.println("Area Of Circle : " + areaOfCircle);
	}

	public static void areaOfTriangle() {
		double height = 15, base = 10;
		double areaOfTriangle = 0.5 * height * base;
		System.out.println("Area Of Triangle : " + areaOfTriangle);
	}
}
