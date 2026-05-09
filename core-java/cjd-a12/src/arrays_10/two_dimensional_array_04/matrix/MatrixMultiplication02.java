package arrays_10.two_dimensional_array_04.matrix;

public class MatrixMultiplication02 {

//	public static void main(String[] args) {
//	int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
//	int b[][] = { { 10, 11 }, { 20, 21 }, { 30, 31 } };
////	int r1 = a.length;
////	int c2 = b[0].length;
////	System.out.println(r1);
////	System.out.println(c2);
//	boolean isMultiplicationPossible = true;
//	for (int i = 0; i < a.length; i++) {
//		for (int j = 0; j < b[i].length; j++) {
//			if (a[0].length != b.length) {
//				isMultiplicationPossible = false;
//			}
//		}
////	System.out.print(a.length);
////	System.out.println(b[0].length);
//	}
//	int r1 = a.length;
//	int r2 = b.length;
//	int c1 = a[0].length;
//	int c2 = b[0].length;
//	if (isMultiplicationPossible) {
//		int res[][] = new int[a.length][b[0].length];
////		for(int i[] : res) {
////			for(int j : i) {
////				System.out.print(j +"\t");
////			}
////			System.out.println();
////		}
//		//a[] columns(c1) or (r1) and b[] rows(r2) or (c2) should be equal
//		for(int i = 0; i < r1; i++) {
//			for(int j = 0; j < c2; j++) {
//				for(int k = 0; k < c1; k++) {
//					res[i][j] += a[i][k] * b[k][j];
//				}
//			}
//		}
//		for (int i[] : res) {
//			for (int j : i) {
//				System.out.print(j +"\t");
//			}
//			System.out.println();
//		}
//	}
//	else {
//		System.out.println("Multiplication is not possible");
//	}
//}

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int b[][] = { { 10, 11 }, { 20, 21 }, { 30, 31 } };

		int r1 = a.length;
//	int r2 = b.length;
		int c1 = a[0].length;
		int c2 = b[0].length;

		int res[][] = new int[a.length][b[0].length];

		// a[][] columns(c1) or (r1) and b[][] rows(r2) or (c2) should be equal
		for (int i = 0; i < r1; i++) {
			for (int j = 0; j < c2; j++) {
				for (int k = 0; k < c1; k++) {
					res[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		for (int i[] : res) {
			for (int j : i) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
	}
}
