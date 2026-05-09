package arrays_10.two_dimensional_array_04;

public class SumOfAllElements02 {

	public static void main(String[] args) {
		int a[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int sum = 0;
		for (int i[] : a) {
			for (int j : i) {
				sum += j;
			}
		}
		System.out.println("Sum of all elements : " + sum);
	}
}
