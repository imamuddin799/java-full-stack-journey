package arrays_10;

public class EvenArray04 {

	public static void main(String[] args) {
		int a[] = { 5, 7, 6, 3, 2, 8, 7, 4 };
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 0)
				c++;
		}
		int even[] = new int[c];

		for (int i = 0, j = 0; i < a.length; i++) {
			if (a[i] % 2 == 0)
				even[j++] = a[i];
		}

		for (int i = 0; i < c; i++) {
			System.out.print(even[i] + " ");
		}

		System.out.println();
		for (int i : even) {
			System.out.print(i + " ");
		}
	}
}
