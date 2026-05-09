package arrays_10.sort_01.assignment;

import java.util.Arrays;

public class EvenOddSort01 {

	public static void main(String[] args) {
		int a[] = { 5, 2, 17, 3, 4, 10, 9, 8 };
		int res[] = new int[a.length];
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
			System.out.println(Arrays.toString(a));
			System.out.println();
		}
		System.out.println(Arrays.toString(res));
		int k = 0;
		for (int i : a) {
			if (i % 2 == 0) {
				res[k++] = i;
			}
		}
		for (int i : a) {
			if (i % 2 == 1) {
				res[k++] = i;
			}
		}
		System.out.println(Arrays.toString(res));
	}
}
