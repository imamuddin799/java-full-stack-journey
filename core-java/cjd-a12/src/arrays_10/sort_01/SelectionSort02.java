package arrays_10.sort_01;

import java.util.Arrays;

public class SelectionSort02 {

	public static void main(String[] args) {
		int a[] = { 4, 10, 9, 15, 2, 7 }; // {3,9,7,2,5};
		System.out.println(Arrays.toString(a) + "\n");
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
		System.out.println(Arrays.toString(a));
	}
}
