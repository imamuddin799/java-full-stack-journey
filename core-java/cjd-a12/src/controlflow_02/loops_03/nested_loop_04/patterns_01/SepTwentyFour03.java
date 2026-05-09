package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepTwentyFour03 {

	public static void main(String[] args) {

		// DATE-24/09/2024

		// PATTERN SWASTIC

		System.out.println("\n PATTERN SWASTIC \n");

		int n = 17, mid = (n / 2) + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == mid || j == mid || i <= mid && j == 1 || i == 1 && j >= mid || i >= mid && j == n
						|| i == n && j <= mid)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN G

		System.out.println("\n PATTERN G \n");

		n = 17;
		mid = (n / 2) + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 || i == n || j == 1 || i == mid && j >= mid || j == n && i >= mid)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN K

		System.out.println("\n PATTERN K \n");

		n = 17;
		mid = (n / 2) + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= mid; j++) {
				if (j == 1 || i + j == mid + 1 || i - j == mid - 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		// PATTERN J

		System.out.println("\n PATTERN J \n");
		n = 17;
		mid = (n / 2) + 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == 1 && j <= mid + (mid / 2) || j == mid || i == n && j <= mid || i >= mid + (mid / 2) && j == 1)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			System.out.println();
		}

		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		// OR

		int star = 1;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= star; j++) {
				System.out.print("*");
			}
			System.out.println();
			star++;
		}

		int space = 4;
		star = 1;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= star; k++) {
				System.out.print("*");
			}
			System.out.println();
			space--;
			star++;
		}
	}
}
