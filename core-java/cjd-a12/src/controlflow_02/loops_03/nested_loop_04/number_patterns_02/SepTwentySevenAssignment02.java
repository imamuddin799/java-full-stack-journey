package controlflow_02.loops_03.nested_loop_04.number_patterns_02;

public class SepTwentySevenAssignment02 {

	public static void main(String[] args) {

		// DATE-27/09/2024

		int n = 1;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("%2d ", n++);
			}
			System.out.println();
		}
		System.out.println();

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.printf("%2d ", j);
			}
			System.out.println();
		}
		System.out.println();

		int space = 3, digit = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.printf("  ");
			}
			for (int j = 1; j <= digit; j++) {
				System.out.printf("%2d", j);
			}
			System.out.println();
			space--;
			digit += 2;
		}
		System.out.println();

		n = 2;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				System.out.printf("%2d ", n);
				n += 2;
			}
			System.out.println();
		}
		System.out.println();

		space = 3;
		digit = 1;
		n = 1;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.printf("   ");
			}
			for (int j = 1; j <= digit; j++) {
				System.out.printf("%2d ", n++);
			}

			if (i == 4)
				n = 1;
			System.out.println();
			if (i <= 3) {
				space--;
				digit++;
			} else {
				space++;
				digit--;
			}
		}
		System.out.println();

		space = 3;
		digit = 1;
		n = 1;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.printf("   ");
			}
			for (int j = 1; j <= digit; j++) {
				System.out.printf("%2d ", n++);
			}
			System.out.println();
			if (i <= 3) {
				space--;
				digit += 2;
			} else {
				space++;
				digit -= 2;
			}
		}
		System.out.println();

		space = 3;
		digit = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= digit; j++) {
				System.out.print(j + " ");
			}
			for (int j = i - 1; j >= 1; j--) {
				System.out.print(j + " ");
			}
			System.out.println();
			space--;
			digit++;
		}
		System.out.println();

		space = 3;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			for (int j = 2; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			space--;

		}
		System.out.println();

		// OR

		digit = 1;
		n = 4;
		space = n - 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = i; j >= 1; j--) {
				System.out.print(j + " ");
			}
			for (int j = 2; j <= i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
			space--;
			digit++;
		}
		System.out.println();

		for (int i = 1; i <= 4; i++) {
			for (int j = i; j <= 4; j++) {
				System.out.print(j + "  ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print(j + "  ");
			}
			System.out.println();
		}
		System.out.println();

		// OR

		n = 5;
		for (int i = 1; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				System.out.print(j + "  ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print(j + "  ");
			}
			System.out.println();
			space--;
			digit++;
		}
		System.out.println();
	}
}
