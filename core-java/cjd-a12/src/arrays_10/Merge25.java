package arrays_10;

import java.util.Arrays;

public class Merge25 {

//	public static void main(String[] args) {
//	int a[] = {5, 3, 8, 7, 6};
//	int b[] = {4, 1, 2, 10};
//	int res[] = new int[a.length + b.length];
//	int k = 0;
//	for(int i = 0; i < a.length; i++) {
//		res[k++] = a[i];
//	}
//	for(int i = 0; i < b.length; i++) {
//		res[k++] = b[i];
//	}
//	System.out.println(Arrays.toString(res));
//}

	public static void main(String[] args) {
		int a[] = { 4, 7, 8, 9, 2 };
		int b[] = { 7, 11, 5, 3 };
		int res[] = new int[a.length + b.length];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			res[k++] = a[i];
		}
		for (int i : b) {
			res[k++] = i;
		}
		System.out.println(Arrays.toString(res));
	}
}
