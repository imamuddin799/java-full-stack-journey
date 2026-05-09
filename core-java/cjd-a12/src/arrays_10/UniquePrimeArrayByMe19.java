package arrays_10;

public class UniquePrimeArrayByMe19 {

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static int noOfUniquePrimeElements(int a[]) {
		int occ[] = new int[a.length];
		int noOfUniquePrimeElement = 0;
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Finding no of Unique Prime Elements
			if (occ[i] != 1 && c == 1 && isPrime(a[i])) {
				noOfUniquePrimeElement++;
			}
		}
		return noOfUniquePrimeElement;
	}

	public static int[] uniquePrimeArray(int a[]) {
		int occ[] = new int[a.length];
		int noOfUniquePrimeElement = noOfUniquePrimeElements(a);
		int uniquePrimeArray[] = new int[noOfUniquePrimeElement];
		int k = 0;
		for (int i = 0; i < a.length; i++) {
			int c = 1;
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					c++;
					occ[j] = 1;
				}
			}
			// Finding and Storing Unique prime elements in new array
			if (occ[i] != 1 && c == 1 && isPrime(a[i])) {
				uniquePrimeArray[k++] = a[i];
			}
		}
		return uniquePrimeArray;
	}

	public static void main(String[] args) {
		int a[] = { 8, 7, 6, 8, 4, 3, 4, 2, 7, 9, 1, 0 };
		int uniquePrimeArray[] = uniquePrimeArray(a);
		if (uniquePrimeArray.length != 0) {
			for (int i : uniquePrimeArray) {
				System.out.println(i);
			}
		} else {
			System.out.println("This array has not a unique prime elements");
		}
	}
}
