package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepTwentyFive05 {

	public static void main(String[] args) {

		// DATE-25/09/2024

		int n;
		int star = 4, space = 0;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			if (i <= 3) {
				space++;
				star--;
			} else {
				space--;
				star++;
			}
		}
		System.out.println();

		star = 1;
		space = 3;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			if (i <= 3) {
				space--;
				star++;
			} else {
				space++;
				star--;
			}
		}
		System.out.println();

		star = 1;
		space = 0;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			System.out.println();
			if (i <= 3) {
				space--;
				star++;
			} else {
				space++;
				star--;
			}
		}
		System.out.println();

		star = 4;
		space = 0;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			System.out.println();
			if (i <= 3) {
				space++;
				star--;
			} else {
				space--;
				star++;
			}
		}
		System.out.println();

		space = 3;
		star = 1;
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			space--;
			star += 2;

		}
		System.out.println();

		space = 4;
		star = 1;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("*   ");
			}
			System.out.println();
			space--;
			star++;

		}
		System.out.println();

		space = 4;
		star = 1;
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			space--;
			star++;

		}
		System.out.println();

		// OR

		n = 8;
		space = n;
		star = 1;
		for (int i = 1; i <= n + 1; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			space--;
			star++;

		}
		System.out.println();

		space = 3;
		star = 1;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			if (i <= 3) {
				space--;
				star += 2;
			} else {
				space++;
				star -= 2;
			}
		}
		System.out.println();

		// OR

		n = 4;
		space = n - 1;
		star = 1;
		for (int i = 1; i <= (n * 2) - 1; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				System.out.print("* ");
			}
			System.out.println();
			if (i <= n - 1) {
				space--;
				star += 2;
			} else {
				space++;
				star -= 2;
			}
		}
		System.out.println();
	}
}
