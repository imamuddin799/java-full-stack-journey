package arrays_10;

public class PrimeArray05 {

	private static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int a[] = { 41, 0, 2, 4, 3, 5, 6, 7, 8, 9, 11, 23, 43, 45, 36, 64 };
		int count = 0;
		for (int i : a) {
			if (isPrime(i))
				count++;
		}
		int prime[] = new int[count];
		int indexOfPrime = 0;
		for (int i : a) {
			if (isPrime(i))
				prime[indexOfPrime++] = i;
		}

		System.out.println("Elements of prime array :");
		for (int i : prime) {
			System.out.print(i + " ");
		}
	}
}
