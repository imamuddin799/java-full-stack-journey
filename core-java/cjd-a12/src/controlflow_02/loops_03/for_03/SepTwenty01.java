package controlflow_02.loops_03.for_03;

public class SepTwenty01 {

	public static void main(String[] args) {

		// DATE-20/09/2024

		// FIRST TEN NATURAL NUMBERS

		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}

		// A z 1
		// B y 2
		// .
		// Z a 26

		int i = 1;
		for (char ch = 'A', ch1 = 'z'; ch <= 'Z'; ch++, ch1--, i++) {
			System.out.println(ch + " " + ch1 + " " + i);
		}

		// OR

		char ch = 'A';
		char ch1 = 'z';
		int dig = 1;
		for (ch = 'A'; ch <= 'Z'; ch++) {
			System.out.println(ch + " " + ch1 + " " + dig);
			ch1--;
			dig++;
		}

		// SUM OF VALUES FROM M TO N

		int m = 10;
		int n = 20;
		int sum = 0;
		for (m = 10; m <= n; m++) {
			sum += m;
		}

		// SUM OF ONLY VALUES FROM M TO N

		n = 20;
		sum = 0;
		for (m = 10; m <= n; m++) {
			sum += m;
		}
		System.out.println(sum);

		// SUM OF ALL ODD VALUES FROM M TO N

		m = 10;
		n = 20;
		sum = 0;
		for (m = 10; m <= n; m++) {
			if (m % 2 != 0)
				sum += m;
		}
		System.out.println(sum);

		// PRODUCT OF FIRST N NUMBERS

		n = 10;
		int product = 1;
		for (m = 1; m <= n; m++) {
			product *= m;
		}
		System.out.println(product);
	}
}
