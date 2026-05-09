package arrays_10;

public class MinMax01 {

	public static void main(String[] args) {
		int a[] = { 11, 8, 7, 3, 9, 10, 4 };
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0 && a[i] > max)
				max = a[i];
		}
		System.out.println("Max even element of the array : " + max);

		int b[] = { 0, 3, 13, 8, 4, 17, 2 };
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			if (b[i] % 2 != 0 && b[i] < min) {
				min = b[i];
			}
		}
		System.out.println("Min odd element of the array : " + min);
	}
}
