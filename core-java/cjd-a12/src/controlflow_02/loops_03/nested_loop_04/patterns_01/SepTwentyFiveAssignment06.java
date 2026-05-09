package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepTwentyFiveAssignment06 {

	public static void main(String[] args) {

		// DATE-25/09/2024

		int star = 1, space = 5;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= star; j++) {
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
				star++;
				space -= 2;
			} else {
				star--;
				space += 2;
			}
		}

		space = 3;
		star = 1;
		for (int i = 1; i <= 7; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= star; j++) {
				if (i % 2 == 0)
					System.out.print("@ ");
				else
					System.out.print("# ");
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
	}
}
