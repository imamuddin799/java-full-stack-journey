package methods_03.oct_07;

public class TableFromMtoN03 {

	public static void main(String[] args) {
		table(23, 12);
	}

	public static void table(int m, int n) {
		int max = (m > n) ? m : n;
		int min = (m > n) ? n : m;
		while (max >= min) {
			if (max - min >= 4) {
				int tab = min + 3;
				for (int i = 1; i <= 10; i++) {
					for (int j = min; j <= tab; j++) {
						System.out.print(j + " * " + i + " = " + (j * i) + "\t|\t");
					}
					System.out.println();
				}
				System.out.println();
				min = min + 4;
			} else {
				for (int i = 1; i <= 10; i++) {
					for (int j = min; j <= max; j++) {
						System.out.print(j + " * " + i + " = " + (j * i) + "\t|\t");
					}
					System.out.println();
				}
				System.out.println();
				min = min + 4;
			}
		}
	}
}
