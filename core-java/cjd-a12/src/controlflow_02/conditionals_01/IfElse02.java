package controlflow_02.conditionals_01;

public class IfElse02 {

	public static void main(String[] args) {

		// DATE-13/09/2024

		int n = 9;
		if (n % 2 == 0) {
			System.out.println(n + " is even");
		} else {
			System.out.println(n + " is odd");
		}

		int a = 9, b = 5;
		if (a > b) {
			System.out.println(a + " is max");
		} else {
			System.out.println(b + " is max");
		}

		n = 15;
		if (n >= 10 && n <= 20) {
			System.out.println(n + " is in range of 10 and 20");
		} else {
			System.out.println(n + " is not in the range of 10 and 20");
		}

		char ch = 'I';
		if (ch >= 'A' && ch <= 'Z') {
			System.out.println(ch + " is Uppercase Alphabet");
		} else {
			System.out.println(ch + " is not a Uppercase Alphabet");
		}

		ch = '5';
		if (ch >= '0' && ch <= '9') {
			System.out.println(ch + " is a digit");
		} else {
			System.out.println(ch + " is not a digit");
		}

		ch = 'n';
		if (ch >= 'a' && ch <= 'z') {
			System.out.println(ch + " is a Lowercase Alphabet");
		} else {
			System.out.println(ch + " is not a Lowercase Alphabet");
		}

		ch = 'M';
		if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			System.out.println(ch + " is an Alphabet");
		} else {
			System.out.println(ch + " is not an Alphabet");
		}

		ch = '$';
		if (!((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9'))) {
			System.out.println(ch + " is a Special character");
		} else {
			System.out.println(ch + " is not a Special character");
		}

		// CLOSEST TO ZERO (0)

		a = 8;
		b = 5;

		if (a < 0) {
			a = -1 * (a);
		}

		if (b < 0) {
			b = -1 * (b);
		}

		if (a < b) {
			System.out.println(a + " is nearest to zero (0)");
		} else {
			System.out.println(b + " is nearest to zero (0)");
		}
	}
}
