package controlflow_02.loops_03.while_01;

public class SepNinteenAssignment02 {

	public static void main(String[] args) {

		// DATE-19/09/2024

		// PRINT ALL SQUARE OF NUMBERS FROM M TO N

		int m = 10, n = 20;
		while (m <= n) {
			System.out.println("Square of " + m + " is " + m * m);
			m++;
		}

		// PRINT NUMBERS DIVISIBLE BY 3 & 4

		m = 10;
		n = 50;
		while (m <= n) {
			if (m % 3 == 0 && m % 4 == 0)
				System.out.println(m + " is Divisible by 3 & 4");
			m++;
		}

		// PRINT NUMBERS DIVISIBLE BY 3 BUT NOT BY 5 FROM 100 TO 200

		m = 100;
		n = 200;
		while (m <= n) {
			if (m % 3 == 0 && m % 5 != 0)
				System.out.println(m + " is Divisible by 3 but not divisible by 5");
			m++;
		}
	}
}
