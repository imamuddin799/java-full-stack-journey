package arrays_10;

public class Arrays03 {

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static boolean isEven(int n) {
		if (n % 2 == 0)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int a[] = { 8, 3, 7, 2, 1, 4, 0, 9, 12, 11 };

		System.out.println("Prime elements :");
		for (int i = 0; i < a.length; i++) {
			if (isPrime(a[i]))
				System.out.print(a[i] + " ");
		}

		System.out.println("\n\nNon-Prime elements :");
		for (int i = 0; i < a.length; i++) {
			if (!isPrime(a[i]))
				System.out.print(a[i] + " ");
		}

		System.out.println("\n\nSum of even elements");
		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (isEven(a[i]))
				sum += a[i];
		}
		System.out.println(sum);

		System.out.println("\n\nSum of odd indexed elements");
		sum = 0;
		for (int i = 0; i < a.length; i++) {
			if (!isEven(i))
				sum += a[i];
		}
		System.out.println(sum);

		System.out.println("\n\nProduct of non-prime elements");
		int product = 1;
		for (int i = 0; i < a.length; i++) {
			if (!isPrime(a[i]) && a[i] != 0)
				product *= a[i];
		}
		System.out.println(product);

		System.out.println("\n\nFirst Half of the array :");
		for (int i = 0; i < a.length / 2; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		System.out.println("\n\nSecond Half of the array in reversed order :");
		for (int i = a.length - 1; i >= a.length / 2; i--) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
