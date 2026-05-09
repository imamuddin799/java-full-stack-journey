package method_overloading_05.oct_16;

import java.util.Scanner;

public class Perimeter05 {

	public static void perimeter(int side) {
		System.out.println("Perimeter of Square : " + (4 * side));
	}

	public static void perimeter(int h, int b) {
		System.out.println("Perimeter of Rectangle : " + (2 * (h + b)));
	}

	public static void perimeter(double radius) {
		System.out.println("Perimeter of Circle : " + (2 * 3.14 * radius));
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("WELCOME TO THE WORLD OF PERIMETER FINDING");
		System.out.print("Enter side of Square to find its Perimeter : ");
		int side = sc.nextInt();
		System.out.println("Enter length and breadth of Rectangle to find its Perimeter : ");
		System.out.print("Enter length : ");
		int h = sc.nextInt();
		System.out.print("Enter breadth : ");
		int b = sc.nextInt();
		System.out.print("Enter radius of Circle to find its Perimeter : ");
		double r = sc.nextDouble();
		perimeter(side);
		perimeter(h, b);
		perimeter(r);
		// perimeter(10);
		// perimeter(10, 20);
		// perimeter(7.0);
		sc.close();
	}
}
