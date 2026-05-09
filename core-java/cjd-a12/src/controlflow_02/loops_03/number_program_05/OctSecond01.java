package controlflow_02.loops_03.number_program_05;

public class OctSecond01 {

	public static void main(String[] args) {

		// DATE-02/10/2024

		// WAP TO FIND NUMBER OF DIGITS PRESENT IN A GIVEN VALUE

		int n = 75612;
		int c1 = 0;
		while (n != 0) {
			c1++;
			n /= 10;
		}
		System.out.println(c1);
		System.out.println();

		// WAP TO PRINT GIVEN NUMBER VERTICALLY BUT IN REVERSE ORDER

		n = 28671;
		while (n != 0) {
			int r = n % 10;
			System.out.println(r);
			n /= 10;
		}
		System.out.println();

		// WAP TO FIND SUM OF DIGITS OF GIVEN NUMBER

		n = 1352345432;
		int sumOfDigits = 0;
		while (n != 0) {
			int r = n % 10;
			sumOfDigits += r;
			n /= 10;
		}
		System.out.println(sumOfDigits);
		System.out.println();

		// WAP TO FIND PRODUCT OF EVEN DIGITS OF GIVEN NUMBER

		n = 135234542;
		int productOfDigits = 1;
		while (n != 0) {
			int r = n % 10;
			if (r % 2 == 0)
				productOfDigits *= r;
			n /= 10;
		}
		System.out.println(productOfDigits);
		System.out.println();

		// WAP TO FIND WHETHER THE GIVEN NUMBER IS SPY NUMBER OR NOT

		System.out.println("spy numbers");
		int n1 = 123;
		n = n1;
		sumOfDigits = 0;
		productOfDigits = 1;
		while (n != 0) {
			int r = n % 10;
			sumOfDigits += r;
			productOfDigits *= r;
			n /= 10;
		}
		if (sumOfDigits == productOfDigits)
			System.out.println(n1 + " is spy number");
		else
			System.out.println(n1 + " is not spy number");
		System.out.println();

		// WAP TO FIND WHETHER THE GIVEN NUMBER IS HARSHAD NUMBER OR NOT

		n1 = 24;
		n = n1;
		sumOfDigits = 0;
		while (n != 0) {
			int r = n % 10;
			sumOfDigits += r;
			n /= 10;
		}
		if (n1 % sumOfDigits == 0)
			System.out.println(n1 + " is Harshad number");
		else
			System.out.println(n1 + " is not Harshad number");
		System.out.println();

		// WAP TO FIND SUM OF PRIME DIGITS EX:- 582319 -> 5+2+3=10

		n = 582319;
		sumOfDigits = 0;
		while (n != 0) {
			int r = n % 10;
			if (r == 2 || r == 3 || r == 5 || r == 7)
				sumOfDigits += r;
			n /= 10;
		}
		System.out.println(sumOfDigits);
		System.out.println();
		// OR

		n = 582319;
		sumOfDigits = 0;
		while (n != 0) {
			int r = n % 10;
			int c = 0;
			for (int i = 2; i <= r / 2; i++) {
				if (r % i == 0) {
					c++;
					break;
				}
			}
			if (c == 0 && r >= 2) {
				sumOfDigits += r;
			}
			n /= 10;
		}
		System.out.println(sumOfDigits);
		System.out.println();

		// WAP TO FIND NUMBER OF 2'S PRESENT IN THE GIVEN NUMBER

		n = 32862172;
		int c = 0;
		while (n != 0) {
			int r = n % 10;
			if (r == 2)
				c++;
			n /= 10;
		}
		System.out.println(c);
		System.out.println();

		// WAP TO PRINT ALL THE NUMBERS WHICH CONTAINS 2 IN IT FROM 10 TO 30

		for (int i = 10; i <= 30; i++) {
			int k = i;
			while (k != 0) {
				int r = k % 10;
				if (r == 2) {
					System.out.println(i);
					break;
				}
				k /= 10;
			}
		}
		System.out.println();

	}
}
