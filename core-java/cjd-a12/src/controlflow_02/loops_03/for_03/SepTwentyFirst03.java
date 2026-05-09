package controlflow_02.loops_03.for_03;

public class SepTwentyFirst03 {

	public static void main(String[] args) {

		// DATE-21/09/2024

		// FIND THE A^B EG:- 2^5=32

		System.out.println("\nFIND THE A^B EG:- 2^5=32");
		int a = 2, b = 5, pow = 1;
		for (int i = 1; i <= b; i++) {
			pow *= a; // pow=pow*a;
		}
		System.out.println(pow);

		// PRINT ALL THE FACTORS FOR THE GIVEN N NUMBERS

		System.out.println("\nPRINT ALL THE FACTORS FOR THE GIVEN N NUMBERS");
		int n = 12;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				System.out.println(i);
		}

		// FIND SUM OF ALL FACTORS

		System.out.println("\nFIND SUM OF ALL FACTORS");
		n = 12;
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				sum = sum + i; // sum+=i;
			}
		}
		System.out.println(sum);

		// FIND SUM OF EVEN FACTORS

		System.out.println("\nFIND SUM OF EVEN FACTORS");
		n = 12;
		sum = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) {
				if (i % 2 == 0)
					sum = sum + i;
			}
		}
		System.out.println(sum);

		// OR

		System.out.println("\nFIND SUM OF EVEN FACTORS");
		n = 12;
		sum = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0 && i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);

		// GIVEN NUMBER IS PRIME OR NOT (1ST WAY)

		System.out.println("\nGIVEN NUMBER IS PRIME OR NOT (1ST WAY)");
		n = 11;
		int c = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				c++;
		}
		if (c == 2)
			System.out.println(n + " is a Prime Number");
		else
			System.out.println(n + " is not a Prime Number");

		// (2ND WAY)

		System.out.println("\nGIVEN NUMBER IS PRIME OR NOT (2ND WAY)");
		n = 15;
		c = 0;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				c++;
		}
		if (c == 0 && n >= 2)
			System.out.println(n + " is a Prime Number");
		else
			System.out.println(n + " is not a Prime Number");

		// (3RD WAY)

		System.out.println("\nGIVEN NUMBER IS PRIME OR NOT (3RD WAY)");
		n = 19;
		c = 0;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				c++;
			break;
		}
		if (c == 0 && n >= 2)
			System.out.println(n + " is a Prime Number");
		else
			System.out.println(n + " is not a Prime Number");

	}
}
