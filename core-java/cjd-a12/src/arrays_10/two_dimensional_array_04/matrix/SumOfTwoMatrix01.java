package arrays_10.two_dimensional_array_04.matrix;

public class SumOfTwoMatrix01 {

	public static void main(String[] args) {
//		int a[][] = {{1,2,3},{4,5,6}};
//		int b[][] = {{7,8,9},{1,2,3}};
//		if(a.length == b.length && a[0].length == b[0].length) {
//			for(int i = 0; i < a.length; i++) {
//				int sum = 0;
//				for(int j = 0; j < a[i].length; j++) {
//					sum = a[i][j] + b[i][j];
//					System.out.print(sum +" ");
//				}
//				System.out.println();
//			}
//		}

		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int b[][] = { { 7, 8, 9 }, { 1, 2, 3 } };
		int r1 = a.length, r2 = b.length;
		int c1 = a[0].length, c2 = b[0].length;
		if (r1 == r2 && c1 == c2) {
			int res[][] = new int[r1][c1];
			for (int i = 0; i < r1; i++) {
				for (int j = 0; j < c1; j++) {
					res[i][j] = a[i][j] + b[i][j];
				}
			}
			for (int i[] : res) {
				for (int j : i) {
					System.out.print(j + " ");
				}
				System.out.println();
			}
		} else {
			System.out.println("The rows and columns are not equal of both the matrices");
		}
	}
}
