package arrays_10;

public class Duplicate13 {

	public static void main(String[] args) {
		int a[] = { 5, 8, 7, 5, 8, 3, 5 };
		int oc[] = new int[a.length];
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					oc[j] = 1;
				}
			}
			// Printing duplicate values
			if (oc[i] != 1 && c > 1) {
				System.out.println(a[i] + " -> " + c);
			}
		}
	}
}
