package arrays_10;

public class RightRotation09 {

	public static void main(String[] args) {
		int n = 3;
		int a[] = { 1, 2, 3, 4, 5, 6 };
		int res[] = new int[a.length];
		int k = a.length - n;
		for (int i = 0; i < a.length; i++, k++) {
			if (k >= a.length)
				k = 0;
			res[i] = a[k];
		}
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
