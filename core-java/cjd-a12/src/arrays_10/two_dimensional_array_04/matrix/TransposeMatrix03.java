package arrays_10.two_dimensional_array_04.matrix;

public class TransposeMatrix03 {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 } };
		int rows = a.length;
		int columns = a[0].length;
		int res[][] = new int[columns][rows];
		for (int i = 0; i < columns; i++) {
			for (int j = 0; j < rows; j++) {
				res[i][j] = a[j][i];
			}
		}
		for (int i[] : res) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
