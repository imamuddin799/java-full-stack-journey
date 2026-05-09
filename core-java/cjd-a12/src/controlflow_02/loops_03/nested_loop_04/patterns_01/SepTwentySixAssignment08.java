package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepTwentySixAssignment08 {

	public static void main(String[] args) {

		// DATE-26/09/2024

		int space = 3, star = 1;
		for (int i = 1; i <= 15; i++) {
			if (i <= 4) {
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
					space = 3;
					star = 1;
				}
			} else if (i >= 5 && i <= 11) {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					if (i == 8 && j == 4)
						System.out.print("$ ");
					else
						System.out.print("* ");
				}
				System.out.println();
				if (i >= 5 && i <= 7) {
					space--;
					star += 2;
				} else {
					if (i == 11) {
						space = 0;
						star = star + 6;
					} else {
						space++;
						star -= 2;
					}
				}
			} else {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					System.out.print("* ");
				}
				System.out.println();
				space++;
				star -= 2;
			}
		}
		System.out.println();

		space = 3;
		star = 1;
		for (int i = 1; i <= 8; i++) {
			if (i <= 4) {
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
					space = 2;
					star = 3;
				}
			} else {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					System.out.print("@ ");
				}
				System.out.println();
			}
		}
		System.out.println();

		star = 1;
		space = 5;
		for (int i = 1; i <= 15; i++) {
			if (i <= 4) {
				for (int j = 1; j <= star; j++) {
					System.out.print("* ");
				}
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= (star * 2) - 1; j++) {
					if (j != 6)
						System.out.print("* ");
				}
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					if (j != 4)
						System.out.print("* ");
				}
				System.out.println();
				if (i <= 3) {
					star += 1;
					space -= 2;
				} else {
					space = 1;
					star = 11;
				}
			} else if (i >= 5 && i <= 8) {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					System.out.print("* ");
				}
				System.out.println();
				if (i >= 5 && i <= 7) {
					space += 1;
					star -= 2;
				} else {
					space = 5;
					star = 3;
				}
			} else {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
		System.out.println();

		star = 1;
		space = 5;
		for (int i = 1; i <= 15; i++) {
			if (i <= 4) {
				for (int j = 1; j <= star; j++) {
					// if(j!=4)
					System.out.print("* ");
				}
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= (star * 2) - 1; j++) {
					if (j != 6)
						System.out.print("* ");
				}
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					if (j <= 3)
						System.out.print("* ");
				}
				System.out.println();
				if (i <= 3) {
					star += 1;
					space -= 2;
				} else {
					space = 1;
					star = 11;
				}
			} else if (i >= 5 && i <= 8) {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					System.out.print("* ");
				}
				System.out.println();
				if (i >= 5 && i <= 7) {
					space += 1;
					star -= 2;
				} else {
					space = 5;
					star = 3;
				}
			} else {
				for (int j = 1; j <= space; j++) {
					System.out.print("  ");
				}
				for (int j = 1; j <= star; j++) {
					System.out.print("* ");
				}
				System.out.println();
			}
		}
		System.out.println();
	}
}
