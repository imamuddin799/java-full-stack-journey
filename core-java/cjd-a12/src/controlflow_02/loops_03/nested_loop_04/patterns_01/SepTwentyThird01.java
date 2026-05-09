package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepTwentyThird01 {

	public static void main(String[] args) {

		// DATE-23/09/2024

		// PATTERN H
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == 3 || j == 1 || j == 4)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN I

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i == 1 || i == 5 || j == 2)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN E

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 3; j++) {
				if (i == 1 || i == 3 || i == 5 || j == 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN N

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j == 1 || j == 5)
					System.out.print("* ");
				else if (i == 2 && j == 2)
					System.out.print("* ");
				else if (i == 3 && j == 3)
					System.out.print("* ");
				else if (i == 4 && j == 4)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN Z

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == 1 || i == 5)
					System.out.print("* ");
				else if (i == 2 && j == 4)
					System.out.print("* ");
				else if (i == 3 && j == 3)
					System.out.print("* ");
				else if (i == 4 && j == 2)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN N
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j == 1 || j == 5 || i == j)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN Z

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == 1 || i == 5 || i + j == 6)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN X

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == j || i + j == 6)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
}
