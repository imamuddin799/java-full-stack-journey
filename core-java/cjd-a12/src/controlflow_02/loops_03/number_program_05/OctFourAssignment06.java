package controlflow_02.loops_03.number_program_05;

public class OctFourAssignment06 {

	public static void main(String[] args) {

		// DATE-04/10/2024

		// WAP TO FIND BINARY OF THE GIVEN NUMBER

		int on = 1024; // 1023; //on= OriginalNumber
		for (int i = 1; i <= on; i++) {
			int n = i, p = 1, bi = 0;
			while (n != 0) {
				int r = n % 2;
				bi += r * p;
				p *= 10;
				n /= 2;
			}
			System.out.println("THE BINARY VALUE FOR " + i + " is " + bi);
		}

		// LCM= LOWEST COMMON MULTIPLE

		int a = 3569;
		int b = 6688;
		// int lcm=1; //LCM= LOWEST COMMON MULTIPLE
		int x = 1;
		while (true) {
			if (x % a == 0 && x % b == 0) {
				System.out.println("THE LCM OF VALUES " + a + ", " + b + " is " + x);
				break;
			}
			x++;
		}

		// GCD= GREATEST COMMON DIVISOR

		a = 10;
		b = 20;
		if (a > b) {
			for (int i = a; i >= 1; i--) {
				if (a % i == 0 && b % i == 0) {
					int gcd = i;
					System.out.println("THE GCD OF VLAUES " + a + ", " + b + " is " + gcd);
					break;
				}
			}
		} else {
			for (int i = b; i >= 1; i--) {
				if (a % i == 0 && b % i == 0) {
					int gcd = i;
					System.out.println("THE GCD OF VLAUES " + a + ", " + b + " is " + gcd);
					break;
				}
			}
		}

		// OR

		a = 10;
		b = 20;
		if (a > b) {
			x = a;
		} else {
			x = b;
		}
		while (true) {
			if (a % x == 0 && b % x == 0) {
				System.out.println("THE GCD OF VLAUES " + a + ", " + b + " is " + x);
				break;
			}
			x--;
		}
	}
}
