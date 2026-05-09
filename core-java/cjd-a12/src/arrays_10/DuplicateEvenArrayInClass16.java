package arrays_10;

import java.util.Arrays;

public class DuplicateEvenArrayInClass16 {

	public static void main(String[] args) {
		int a[] = { 8, 7, 5, 6, 2, 6, 3, 4, 8, 4, 8, 4, 7 };
		int oc[] = new int[a.length];
		int ec = 0;
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					oc[j] = 1;
				}
			}
			if (oc[i] != 1 && a[i] % 2 == 0 && c > 1) {
				oc[i] = 2;
				ec++;
			}
		}
		int even[] = new int[ec];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (oc[i] == 2) {
				even[k++] = a[i];
			}
		}
		System.out.println(Arrays.toString(even));
	}
}
