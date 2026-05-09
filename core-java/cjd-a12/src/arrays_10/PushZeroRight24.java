package arrays_10;

import java.util.Arrays;

public class PushZeroRight24 {

	public static void main(String[] args) {
		int a[] = { 5, 3, 0, 7, 6, 0, 0, 1, 0, 2 };
		int res[] = new int[a.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				res[k++] = a[i];
			}
		}
		System.out.println(Arrays.toString(res));
	}
}
