package controlflow_02.conditionals_01;

public class IfElseLadder07 {

	public static void main(String[] args) {

		// DATE-14/09/2024

		int n = 7;
		if (n > 0) {
			System.out.println(n + " is Positive");
		} else if (n < 0) {
			System.out.println(n + " is Negative");
		} else {
			System.out.println(n + " is zero");
		}

		// MAXIMUM OF THREE NUMBERS

		int a = 10, b = 20, c = 30;
		if (a > b && a > c) {
			System.out.println(a + " is max");
		} else if (b > c) {
			System.out.println(b + " is max");
		} else {
			System.out.println(c + " is max");
		}
	}
}
