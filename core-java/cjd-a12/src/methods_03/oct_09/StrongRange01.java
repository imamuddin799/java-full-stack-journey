package methods_03.oct_09;

public class StrongRange01 {

	// DATE-09-10-2024

	public static boolean isStrong(int n) {
		int sum = 0, originalNumber = n;
		while (n != 0) {
			int remainder = n % 10;
			sum += factorial(remainder);
			n /= 10;
		}
		return originalNumber == sum;
	}

	public static int factorial(int n) {
		int factorial = 1;
		for (int i = 2; i <= n; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static void main(String[] args) {
		int m = 1, n = 100000000;
		for (int i = m; i <= n; i++) {
			if (isStrong(i))
				System.out.println(i);
		}
	}
}
