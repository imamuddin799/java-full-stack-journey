package arrays_10;

import java.util.Arrays;

public class DistinctOddArrayInClass23 {

	public static void main(String[] args) {
		int a[] = { 8, 7, 6, 8, 4, 3, 4, 2, 7, 9, 1, 0 };
		int occ[] = new int[a.length];
		int oc = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					occ[j] = 1;
				}
			}
			// Printing Distinct odd elements
			if (occ[i] == 0 && a[i] % 2 == 1) {
				oc++;
				occ[i] = 2;
			}
		}
		int odd[] = new int[oc];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (occ[i] == 2) {
				odd[k++] = a[i];
			}
		}
		System.out.println(Arrays.toString(odd));
	}
}
