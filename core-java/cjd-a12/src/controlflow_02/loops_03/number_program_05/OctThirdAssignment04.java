package controlflow_02.loops_03.number_program_05;

public class OctThirdAssignment04 {

	public static void main(String[] args) {

		// DATE-03/10/2024

		// WAP TO CHECK WHETHER THE GIVEN NUMBER IS ARMSTRONG NUMBER OR NOT

		int n = 1634, t = n;
		int c = 0, sum = 0;
		while (n != 0) {
			c++;
			n /= 10;
		}
		n = t;
		while (n != 0) {
			int f = 1;
			int r = n % 10;
			for (int i = 1; i <= c; i++) {
				f = f * r;
			}
			sum = sum + f;
			// System.out.println(sum);
			n /= 10;
		}
		if (sum == t)
			System.out.println(t + " IS A ARMSTRONG NUMBER");
		else
			System.out.println(t + " IS NOT A ARMSTRONG NUMBER");

		// WAP TO FORM A NUMBER USING ODD POSITION DIGITS

		n = 5387622;
		c = 0;
		t = n;
		while (n != 0) {
			c++;
			n /= 10;
		}
		n = t;
		if (c % 2 == 0) {
			int s = 0;
			int p = 1;
			while (n != 0) {
				int r = n % 100;
				int d = r / 10;
				s = s + p * d;
				p *= 10;
				n /= 100;
			}
			System.out.println(s);
		} else {
			int s = 0;
			int p = 1;
			while (n != 0) {
				int r = n % 10;
				s = s + p * r;
				p *= 10;
				n /= 100;
			}
			System.out.println(s);
		}

		// WAP TO FIND SUM OF DIGITS UNTIL WE GET SINGLE DIGIT

		n = 254778;
		while (n != 0) {
			int u = n;
			int s = 0;
			while (u != 0) {

				int r = u % 10;
				s = s + r;
				u /= 10;
			}

			if (s <= 9) {
				System.out.println(s);
				n = s;
				n /= 10;
			} else {
				n = s * 10;
				n /= 10;
			}
		}
	}
}
