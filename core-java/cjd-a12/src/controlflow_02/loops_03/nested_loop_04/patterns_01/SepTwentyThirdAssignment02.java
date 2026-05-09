package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepTwentyThirdAssignment02 {

	public static void main(String[] args) {

		// DATE-23/09/2024

		// PATTERN G

		System.out.println("\n PATTERN G \n");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == 1 || i == 5 || j == 1 || i == 3 && j >= 3 || j == 5 && i >= 3)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN J

		System.out.println("\n PATTERN J \n");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == 1 || j == 3 || i == 5 && j <= 3 || i >= 4 && j == 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN SWASTIKA

		System.out.println("\n PATTERN SWASTIKA \n");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == 3 || j == 3 || i <= 3 && j == 1 || i == 1 && j >= 3 || i >= 3 && j == 5 || i == 5 && j <= 3)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN A U

		System.out.println("\n PATTERN AU \n");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 1 || j == 4 || j == 6 || j == 9 || i == 1 && j <= 4 || i == 3 && j <= 4 || i == 5 && j >= 6)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN K

		System.out.println("\n PATTERN K \n");

		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= 4; j++) {
				if (j == 1 || i + j == 5 || i - j == 3)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN SWASTIKA 2ND WAY

		System.out.println("\n PATTERN SWASTIKA 2ND WAY\n");

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (i == 3 || j == 3 || i != 4 && j == 1 || i == 1 && j != 2 || i != 2 && j == 5 || i == 5 && j != 4)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN J

		System.out.println("\n PATTERN J \n");
		int n = 17, m = (n / 2) + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 || j == m || i == n && j <= m || i > m && j == 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}
	}
	/**
	11	12	13	14	15
	21	22	23	24	25
	31	32	33	34	35
	41	42	43	44	45
	51	52	53	54	55

	*	*	*	*	*
	*
	*		*	*	*
	*				*
	*	*	*	*	*

	*	*	*	*
			*
			*
	*		*
	*	*	*

	11	12	13	14
	21	22	23	24
	31	32	33	34
	41	42	43	44
	51	52	53	54
	61	62	63	64
	71	72	73	74

	*			*
	*		*
	*	*
	*
	*	*
	*		*
	*			*

	*/
}
