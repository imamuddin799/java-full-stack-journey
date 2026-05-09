package arrays_10.sort_01.assignment;

import java.util.Arrays;

public class PrimeArray02 {

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
		int a[] = { 5, 2, 8, 3, 7, 1, 4, 0, 11 };
		int c = 0;
		System.out.println("Given Array : " + Arrays.toString(a));
		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
			// After completion of swapping the ith indexed value is sorted so we can check
			// whether it is prime or not and thats how it will not check is again for
			// primeness
			if (isPrime(a[i])) {
				c++;
			}
		}
		System.out.println("Sorted Array : " + Arrays.toString(a));
		int prime[] = new int[c];
		int k = 0;
		for (int i : a) {
			if (isPrime(i)) {
				prime[k++] = i;
			}
		}
		System.out.println("Prime Array : " + Arrays.toString(prime));
	}
}
