package controlflow_02.loops_03.while_01;

public class SepTwenty03 {

	public static void main(String[] args) {

		// DATE-20/09/2024

		// SUM OF N NATURAL NUMBERS

		int a = 10;
		int b = 1;
		int res = 0;
		while (b <= a) {
			res += b;
			b++;
		}
		System.out.println(res);

		// SUM OF EVEN FROM M TO N

		int m = 10, n = 50, sum = 0;
		while (m <= n) {
			if (m % 2 == 0)
				sum += m;
			m++;
		}
		System.out.println(sum);

		// MULTIPLICATION TABLE OF 6
		// 6 * 1 = 6
		// 6 * 2 = 12

		int i = 1;
		while (i <= 10) {
			System.out.println(6 + " * " + i + " = " + (6 * i));
			i++;
		}
	}
}
