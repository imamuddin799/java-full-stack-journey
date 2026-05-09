package controlflow_02.loops_03.nested_loop_04;

public class SepTwentyFisrtAssignment02 {

	public static void main(String[] args) {

		// DATE-20/09/2024

		// CHECK GIVEN NUMBER IS PERFECT OR NOT

		System.out.println("\nCHECK GIVEN NUMBER IS PERFECT OR NOT");
		int n = 28;
		int sum = 0;
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		if (sum == n)
			System.out.println(n + " is a Perfect Number");
		else
			System.out.println(n + " is not a Perfect Number");

		// TESTING

		System.out.println("\nTESTING CHECK GIVEN NUMBER IS PERFECT OR NOT");
		n = 20000;
		for (int i = 1; i <= n; i++) {
			int sum1 = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0)
					sum1 = sum1 + j;
			}
			if (sum1 == i) {
				System.out.println(i + " is a Perfect Number");
				sum1 = 0;
			} else {
				// System.out.println(i+" is not a Perfect Number");
				sum1 = 0;
			}
		}

		// FIND FACTORIAL OF ODD NUMBERS 2-10

		System.out.println("\nFIND FACTORIAL OF ODD NUMBERS 2-10");
		int fact = 1;
		for (int i = 2; i <= 10; i++) {
			if (i % 2 != 0) {
				for (int j = 1; j <= i; j++) {
					fact *= j;
				}
				System.out.println("Factorial of " + i + " = " + fact);
				fact = 1;
			}
		}

		// FIND NTH(5) POWER OF EVERY VALUE FROM A TO B (EX:- 10 TO 20)

		System.out.println("\nFIND NTH POWER OF EVERY VALUE FROM A TO B (EX:- 10 TO 20)");
		n = 5;
		int a = 10;
		int b = 20;
		int power = 1;
		for (int i = a; i <= b; i++) {
			for (int j = 1; j <= n; j++) {
				power = power * i;
			}
			System.out.println(n + "th power of value " + i + " = " + power);
			power = 1;
		}
	}
}
