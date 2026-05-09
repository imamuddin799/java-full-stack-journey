package methods_03.oct_07;

public class TableFromMtoN02 {

	// DATE-07/10/2024

	// WAP TO PRINT TABLE FROM M TO N

	public static void table(int n) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(n + " * " + i + " = " + (n * i));
		}
	}

	public static void main(String[] args) {
		int m = 10, n = 20;
		for (int i = m; i <= n; i++) {
			table(i);
			System.out.println();
		}
	}
}
