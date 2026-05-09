package arrays_10;

public class PairUniqueSumFive28 {

	public static void main(String[] args) {
		int a[] = { 4, 1, 4, 5, 0, 3, 2, 3, 5, -1 };
		int t = 5;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] + a[i + 1] == t) {
				System.out.println(a[i] + ", " + a[i + 1]);
				i++;
			}
		}
	}
}
