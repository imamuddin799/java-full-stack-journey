package controlflow_02.loops_03.number_program_05;

public class OctThird03 {

	public static void main(String[] args) {

		// DATE-03/10/2024

		// WAP TO REVERSE THE GIVEN NUMBER

		int n = 143;
		int rev = 0;
		while (n != 0) {
			int r = n % 10;
			rev = rev * 10 + r;
			n /= 10;
		}
		System.out.println(rev);

		// WAP TO CHECK WHETHER THE GIVEN NUMBER IS PALINDROME OR NOT

		n = 15251;
		int n1 = n;
		rev = 0;
		while (n != 0) {
			int r = n % 10;
			rev = rev * 10 + r;
			n /= 10;
		}
		if (rev == n1)
			System.out.println(n1 + "  IS PALINDROME NUMBER");
		else
			System.out.println(n1 + " IS NOT PALINDROME NUMBER");

		// WAP TO FORM A NUMBER USING EVEN DIGITS EX:- N=253876 -> RES=286

		n = 253876;
		int res = 0, p = 1;
		while (n != 0) {
			int r = n % 10;
			if (r % 2 == 0) {
				res = res + p * r;
				p = p * 10;
			}
			n /= 10;
		}
		System.out.println(res);

		// WAP TO FORM A NUMBER USING PRIME DIGITS EX:- N=252491376 -> RES=25237

		n = 25243876;
		res = 0;
		p = 1;
		while (n != 0) {
			int c = 0;
			int r = n % 10;
			for (int j = 2; j <= r / 2; j++) {
				if (r % j == 0) {
					c++;
					break;
				}
			}
			if (c == 0 && r >= 2) {
				res = res + p * r;
				p = p * 10;
			}
			n /= 10;
		}
		System.out.println(res);

		// WAP TO CHECK WHETHER THE GIVEN NUMBER IS STRONG NUMBER OR NOT

		n = 145;
		n1 = n;
		res = 0;
		while (n != 0) {
			int f = 1;
			int r = n % 10;
			for (int i = 1; i <= r; i++) {
				f = f * i;
			}
			res = res + f;
			n /= 10;
		}
		if (res == n1)
			System.out.println(n1 + " IS A STRONG NUMBER");
		else
			System.out.println(n1 + " IS NOT A STRONG NUMBER");

	}
}
