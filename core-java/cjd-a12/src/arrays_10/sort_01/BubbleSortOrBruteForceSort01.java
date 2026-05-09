package arrays_10.sort_01;

import java.util.Arrays;

public class BubbleSortOrBruteForceSort01 {

	public static void main(String[] args) {
		// Ascending Order
		int a[] = { 4, 7, 3, 9, 2 };
		for (int i = 0; i < a.length - 1; i++) {
			System.out.println(Arrays.toString(a));
			for (int j = 1; j < a.length - i; j++) {
				if (a[j - 1] > a[j]) {
					int temp = a[j - 1];
					a[j - 1] = a[j];
					a[j] = temp;
					System.out.println(Arrays.toString(a));
				}
			}
			System.out.println();
		}
		System.out.println(Arrays.toString(a));
	}
}
