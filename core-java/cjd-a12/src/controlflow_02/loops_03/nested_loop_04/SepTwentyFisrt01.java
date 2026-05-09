package controlflow_02.loops_03.nested_loop_04;

public class SepTwentyFisrt01 {

	public static void main(String[] args) {

		// DATE-20/09/2024

		// FIND FACTORIAL OF EACH VALUE FROM M TO N

		int m = 3, n = 8;
		for (int i = m; i <= n; i++) {
			int fact = 1;
			for (int j = 1; j <= i; j++) {
				fact = fact * j;
			}
			System.out.println(fact);
		}

		// PRINT TABLE FROM 5 TO 10

		m = 5;
		n = 10;
		for (int i = m; i <= n; i++) {
			for (int j = 1; j <= 10; j++) {
				System.out.println(i + " * " + j + " = " + (i * j));
			}
			System.out.println();
		}

		// PRINT TABLE FROM 5 TO 10 IN HORIZONTALLY
		/**
		 * m=5; n=15; for(int i=1; i<=10; i++){ for(int j=m; j<=n; j++){
		 * System.out.print(i+" * "+j+" = "+(i*j)+" | "); } System.out.println(); }
		 */
		m = 5;
		n = 35;
		while (n - m >= 4) {
			int a = m + 3;
			for (int i = 1; i <= 10; i++) {
				for (int j = m; j <= a; j++) {
					if (i * j < 10) {
						if (i < 10)
							System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
						else
							System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
					} else if (i * j < 100) {
						if (i < 10)
							System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
						else
							System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
					} else {
						if (i < 10)
							System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
						else
							System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
					}
				}
				System.out.println();
			}
			System.out.println();
			m = m + 4;
		}
		for (int i = 1; i <= 10; i++) {
			for (int j = m; j <= n; j++) {
				if (i * j < 10) {
					if (i < 10)
						System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
					else
						System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
				} else if (i * j < 100) {
					if (i < 10)
						System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
					else
						System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
				} else {
					if (i < 10)
						System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
					else
						System.out.print(j + " * " + i + " = " + (i * j) + "\t|\t");
				}
			}
			System.out.println();
		}
	}
}
