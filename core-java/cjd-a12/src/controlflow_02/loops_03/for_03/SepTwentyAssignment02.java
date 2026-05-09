package controlflow_02.loops_03.for_03;

public class SepTwentyAssignment02 {

	public static void main(String[] args) {

		// DATE-20/09/2024

		// SUM OF SQUARES OF ALL VALUES FROM M TO N

		int n = 20, sumOfSquare = 0;
		for (int m = 10; m <= n; m++) {
			int square = m * m;
			sumOfSquare += square;
		}
		System.out.println(sumOfSquare);

		// PRODUACT OF ODD VALUES FROM M TO N

		n = 20;
		int productOfOdd = 1;
		for (int m = 10; m <= n; m++) {
			if (m % 2 != 0)
				productOfOdd *= m;
		}
		System.out.println(productOfOdd);

		// PRINT ALL VALUES ENDS WITH 2 FROM 10 TO 100;

		n = 100;
		for (int m = 10; m <= n; m++) {
			if (m % 10 == 2)
				System.out.print(m + "\t");
		}
	}
}
