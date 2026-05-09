package arrays_10;

public class DistinctOdd21 {

	public static void main(String[] args) {
		int a[] = { 8, 7, 6, 8, 4, 3, 4, 2, 7, 9, 1, 0 };
		int occ[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Printing Distinct odd elements
			if (occ[i] == 0 && a[i] % 2 == 1) {
				System.out.println(a[i] + " -> " + c);
			}
		}
	}
}
