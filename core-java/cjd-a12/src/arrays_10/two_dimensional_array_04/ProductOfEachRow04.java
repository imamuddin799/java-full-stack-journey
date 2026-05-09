package arrays_10.two_dimensional_array_04;

public class ProductOfEachRow04 {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int i[] : a) {
			int product = 1;
			for (int j : i) {
				product *= j;
			}
			System.out.println("Product of each row : " + product);
		}
	}
}
