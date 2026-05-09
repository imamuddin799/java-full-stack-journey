package controlflow_02.conditionals_01;

public class AbsoluteDiff03 {

	public static void main(String[] args) {

		// DATE-14/09/2024

		int a = 15, b = 20;
		if (a > b) {
			System.out.println(a - b);
		} else {
			System.out.println(b - a);
		}
		System.out.println(Math.abs(a - b));

		// CLOSEST TO ZERO (0)

		if (Math.abs(a - 0) < Math.abs(b - 0)) {
			System.out.println(a + " is closest to zero (0)");
		} else {
			System.out.println(b + " is closest to zero (0)");
		}
	}
}
