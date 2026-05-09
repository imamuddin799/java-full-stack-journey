package controlflow_02.loops_03.nested_loop_04.patterns_01;

public class SepThirty10 {

	public static void main(String[] args) {

		// DATE-30/09/2024

		int r = 10;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		System.out.println();

		r = 10; // r=row
		int c = r; // c=column
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (i + j >= r + 1)
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();

		r = 6; // r=row
		c = r; // c=column
		char x = 'A';
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (i + j >= r + 1)
					System.out.print(x++);
				else
					System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();

		r = 10; // r=row
		c = r; // c=column
		x = 'A';
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (i + j >= r + 1)
					System.out.print(x);
				else
					System.out.print(' ');
			}
			System.out.println();
			x++;
		}
		System.out.println();

		r = 10; // r=row
		c = r * 2 - 1; // c=column
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if (i + j >= r + 1 && j - i <= r - 1)
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();

		r = 10; // r=row
		c = r; // c=column
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if ((i + j >= r + 1 && i <= r / 2 + 1) || (i + j <= r + 1 && i >= r / 2 + 1))
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();

		r = 11; // r=row
		c = r; // c=column
		int mid = (r / 2) + 1;
		for (int i = 1; i <= r; i++) {
			for (int j = 1; j <= c; j++) {
				if ((i + j >= mid + 1 && j - i <= mid - 1 && i <= mid)
						|| (i - j <= mid - 1 && i + j <= mid * 3 - 1 && i >= mid))
					System.out.print('*');
				else
					System.out.print(' ');
			}
			System.out.println();
		}
		System.out.println();

	}
}
