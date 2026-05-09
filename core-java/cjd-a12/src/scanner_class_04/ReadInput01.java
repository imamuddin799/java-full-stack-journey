package scanner_class_04;

import java.util.Scanner;

public class ReadInput01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Byte value : ");
		byte a = sc.nextByte();
		System.out.print("Enter Short value : ");
		short b = sc.nextShort();
		System.out.print("Enter Int value : ");
		int c = sc.nextInt();
		System.out.print("Enter Long value : ");
		long d = sc.nextLong();
		System.out.print("Enter Float value : ");
		float e = sc.nextFloat();
		System.out.print("Enter Double value : ");
		double f = sc.nextDouble();
		System.out.print("Enter Boolean value : ");
		boolean g = sc.nextBoolean();
		System.out.println("Byte value : " + a);
		System.out.println("Short value : " + b);
		System.out.println("Int value : " + c);
		System.out.println("Long value : " + d);
		System.out.println("Float value : " + e);
		System.out.println("Double value : " + f);
		System.out.println("Boolean value : " + g);
		sc.close();
	}
}
