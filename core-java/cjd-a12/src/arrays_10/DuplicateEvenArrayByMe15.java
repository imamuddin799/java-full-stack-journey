package arrays_10;

public class DuplicateEvenArrayByMe15 {

	public static int duplicateEvenElements(int a[]) {
		int occ[] = new int[a.length];
		int noOfDuplicateElements = 0;
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Finding no of Duplicate Even Elements
			if (occ[i] != 1 && c > 1 && a[i] % 2 == 0) {
				noOfDuplicateElements++;
			}
		}
		return noOfDuplicateElements;
	}

	public static int[] duplicateEvenArray(int a[]) {
		int occ[] = new int[a.length];
		int noOfDuplicateElements = duplicateEvenElements(a);
		int duplicateEvenArray[] = new int[noOfDuplicateElements];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Finding and storing Duplicate Even Elements in a new array
			if (occ[i] != 1 && c > 1 && a[i] % 2 == 0) {
				duplicateEvenArray[k++] = a[i];
			}
		}
		return duplicateEvenArray;
	}

	public static void main(String[] args) {

		int a[] = { 8, 7, 6, 8, 4, 3, 4, 2, 7, 9, 1, 0 };
		int duplicateEvenArray[] = duplicateEvenArray(a);
		if (duplicateEvenArray.length != 0) {
			for (int i : duplicateEvenArray) {
				System.out.println(i);
			}
		}
	}
}
