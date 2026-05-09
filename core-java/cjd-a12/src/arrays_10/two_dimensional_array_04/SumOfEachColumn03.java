package arrays_10.two_dimensional_array_04;

public class SumOfEachColumn03 {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i = 0; i < a[0].length; i++) {
			int sum = 0;
			for (int j = 0; j < a.length; j++) {
				sum += a[j][i];
			}
			System.out.println("Sum of each column : " + sum);
		}

		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = 0; j < a[i].length; j++) {
				sum += a[j][i];
			}
			System.out.println("Sum of each column : " + sum);
		}

//		for(int i[] : a) {
//			for(int j : i) {
//				System.out.print(j + " ");
//			}
//			System.out.println();
//		}
	}
}
