package arrays_10;

public class DistinctOddArrayByMe22 {

	public static int noOfDistinctOddElement(int a[]) {
		int occ[] = new int[a.length];
		int noOfDistinctOddElement = 0;
		for (int i = 0; i < a.length; i++) {
			// int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					// c++;
					occ[j] = 1;
				}
			}
			// Finding no of Distinct Odd Elements
			if (occ[i] != 1 && a[i] % 2 != 0) {
				noOfDistinctOddElement++;
			}
		}
		return noOfDistinctOddElement;
	}

	public static int[] distinctOddArray(int a[]) {
		int occ[] = new int[a.length];
		int noOfDistinctOddElement = noOfDistinctOddElement(a);
		int distinctOddArray[] = new int[noOfDistinctOddElement];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			// int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					// c++;
					occ[j] = 1;
				}
			}
			// Finding and Storing Distinct Odd Elements
			if (occ[i] != 1 && a[i] % 2 != 0) {
				distinctOddArray[k++] = a[i];
			}
		}
		return distinctOddArray;
	}

	public static void main(String[] args) {
		int a[] = { 8, 7, 6, 8, 4, 3, 4, 2, 7, 9, 1, 0 };
		int distinctOddArray[] = distinctOddArray(a);
		if (distinctOddArray.length != 0) {
			for (int i : distinctOddArray) {
				System.out.println(i);
			}
		} else {
			System.out.println("The array has not a distinct odd elements");
		}
	}
}
