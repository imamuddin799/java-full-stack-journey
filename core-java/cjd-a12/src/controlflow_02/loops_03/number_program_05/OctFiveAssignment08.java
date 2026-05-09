package controlflow_02.loops_03.number_program_05;

public class OctFiveAssignment08 {

	public static void main(String[] args) {

		// DATE-05/10/2024

		// WAP TO FIND DIVISION WITHOUT USING '/' AND MODULO DIVISION WITHOUT USING '%'
		// a=55, b=20; q=2, r=15

		int a = 55; // dividend
		int q = 0;
		while (a >= 20) {
			a -= 20; // divisor
			q++;
		}
		System.out.println("Remainder : " + a);
		System.out.println("Quotient : " + q);

		// WAP TO FIND MULTIPLICATION WITHOUT USING '*'
		// a=5, b=10, p=a*b=50;

		a = 10;
		int p = 0;
		while (a != 0) {
			p += 120;
			a--;
		}
		System.out.println("Product is : " + p);
	}
}
