package methods_03.oct_08;

public class OctEightAssignment04 {

	// DATE-08-10-2024

	// FIND HARSHAD NUMBER FROM M=10 TO N=500
	public static boolean harshad(int n) {
		int sum = 0, originalNumber = n;
		while (n != 0) {
			int remainder = n % 10;
			sum += remainder;
			n /= 10;
		}
		return originalNumber % sum == 0;
	}

	// FIND SPY NUMBER FROM M=10 TO N=100

	public static boolean spyNumber(int n) {
		int sum = 0, product = 1;
		while (n != 0) {
			int remainder = n % 10;
			product *= remainder;
			sum += remainder;
			n /= 10;
		}
		return sum == product;
	}
	// FIND STRONG NUMBER FROM M=100 TO N=1000_000_00

	public static boolean strong(int n) {
		int originalNumber = n;
		int sum = 0;
		while (n != 0) {
			int remainder = n % 10;
			int factorial = 1;
			for (int i = 1; i <= remainder; i++) {
				factorial *= i;
			}
			sum += factorial;
			n /= 10;
		}
		return originalNumber == sum;
	}

	// FIND ARMSTRONG NUMBER FROM M=100 TO 100000000

	public static boolean armStrong(int n) {
		int count = 0, sum = 0, originalNumber = n;
		while (n != 0) {
			count++;
			n /= 10;
		}
		n = originalNumber;
		while (n != 0) {
			int remainder = n % 10;
			int product = 1;
			for (int i = 1; i <= count; i++) {
				product *= remainder;
			}
			sum += product;
			n /= 10;
		}
		return sum == originalNumber;
	}

	public static void main(String[] args) {
		int m = 10, n = 100;
		for (int i = m; i <= n; i++) {
			if (spyNumber(i)) {
				System.out.println(i + " IS A SPY NUMBER");
			}
		}
		m = 100;
		n = 100000000;
		for (int i = m; i <= n; i++) {
			if (strong(i))
				System.out.println(i + " IS A STRONG NUMBER");
		}
		m = 100;
		n = 100000000;
		for (int i = m; i <= n; i++) {
			if (armStrong(i)) {
				System.out.println(i + " IS A ARMSTRONG NUMBER");
			}
		}
		m = 10;
		n = 500;
		for (int i = m; i <= n; i++) {
			if (harshad(i))
				System.out.println(i + " IS A HARSHAD NUMBER");
		}
	}
}
