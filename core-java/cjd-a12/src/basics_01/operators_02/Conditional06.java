package basics_01.operators_02;

public class Conditional06 {

	public static void main(String[] args) {

		// DATE-12-09-2024

		// CONDITIONAL OPERATOR

		int a = 10, b = 50;
		int max = (a > b) ? a : b;
		System.out.println(max);
		System.out.println((a > b) ? a : b);

		int n = 15;
		n = 8;
		String result = (n % 2 == 0) ? n + " is even" : n + " is odd";
		System.out.println(result);

		// MAXIMUM OF GIVEN 3 NUMBERS

		b = 20;
		int c = 15, m1, m;
		m1 = (a > b) ? a : b;
		m = (m1 > c) ? m1 : c;
		System.out.println(m);

		a = 30;
		b = 25;
		c = 15;
		m = (a > b) ? ((a > c) ? a : c) : (b > c) ? b : c;
		System.out.println(m);
	}
}
