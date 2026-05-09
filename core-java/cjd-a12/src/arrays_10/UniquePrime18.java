package arrays_10;

public class UniquePrime18 {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int a[] = { 8, 7, 6, 8, 4, 3, 4, 2, 7, 9, 1, 0 };
		int occ[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Printing Unique Prime Elements
			if (occ[i] != 1 && c == 1 && isPrime(a[i])) {
				System.out.println(a[i] + " -> " + c);
			}
		}
	}
}
