package arrays_10;

import java.util.Arrays;

public class UniquePrimeArrayInClass20 {

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
		int pc = 0;
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Storing Unique Prime Elements
			if (occ[i] != 1 && c == 1 && isPrime(a[i])) {
				pc++;
				occ[i] = 2;
			}
		}
		int prime[] = new int[pc];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (occ[i] == 2) {
				prime[k++] = a[i];
			}
		}
		System.out.println(Arrays.toString(prime));
	}
}
