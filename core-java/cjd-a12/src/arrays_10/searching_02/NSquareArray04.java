package arrays_10.searching_02;

import java.util.Arrays;

public class NSquareArray04 {

	public static void main(String[] args) {
//		int n = 4;
//		int a[] = new int[n*n];
//		int skip = 0;
//		for(int i = a.length-1; i >= 0; i--) {
//			for(int j = 1; j <= n; j++) {
//				a[i] = j;
//				if(j < n) {
//					i--;
//				}
//		System.out.println(Arrays.toString(a));
//			}
//			i -= skip;
//			skip++;
//			n--;
//		}
//		System.out.println(Arrays.toString(a));

		int n = 3;
		int a[] = new int[n * n];
		int skip = n - 1;
		int start = 1;
		for (int i = skip; i < a.length - 1; i++) {
			n = start;
			for (int j = n; j >= 1; j--) {
				a[i++] = j;
			}
			start++;
			skip--;
			i += skip - 1;
		}

		System.out.println(Arrays.toString(a));
	}
}
