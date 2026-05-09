package controlflow_02.loops_03.number_program_05;

public class OctFive07 {

	public static void main(String[] args) {

		// DATE-05/10/2024

		// WAP TO FIND BINARY NUMBER OF GIVEN NUMBER

		int on = 4; // on= Original Number
		int n = on;
		String res = "";
		while (n != 0) {
			int r = n % 2;
			res = r + res;
			n = n / 2;
		}
		System.out.println(res);

		// WAP TO FIND OCTAL NUMBER OF GIVEN NUMBER

		on = 84; // on= Original Number
		n = on;
		res = "";
		while (n != 0) {
			int r = n % 8;
			res = r + res;
			n = n / 8;
		}
		System.out.println(res);

		// WAP TO FIND HEXADECIMAL OF GIVEN NUMBER
		on = 78; // on= Original Number
		n = on;
		res = "";
		while (n != 0) {
			int r = n % 16;
			String s = "";
			switch (r) {
			case 10:
				s = "A";
				break;
			case 11:
				s = "B";
				break;
			case 12:
				s = "C";
				break;
			case 13:
				s = "D";
				break;
			case 14:
				s = "E";
				break;
			case 15:
				s = "F";
				break;
			default:
				s += r;
				break;
			}
			// System.out.println(r);
			res = s + res;
			n = n / 16;
		}
		System.out.println(res);

		// OR

		on = 76; // on= Original Number
		n = on;
		res = "";
		while (n != 0) {
			int r = n % 16;
			switch (r) {
			case 10:
				res = 'A' + res;
				break;
			case 11:
				res = 'B' + res;
				break;
			case 12:
				res = 'C' + res;
				break;
			case 13:
				res = 'D' + res;
				break;
			case 14:
				res = 'E' + res;
				break;
			case 15:
				res = 'F' + res;
				break;
			default:
				res = r + res;
			}
			n = n / 16;
		}
		System.out.println(res);

		// GCD

		int a = 10, b = 20;
		for (int i = (a < b ? a : b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) {
				System.out.println(i);
				break;
			}
		}
		a = 24;
		b = 14;
		int min = (a > b) ? b : a;
		if (a % min == 0 && b % min == 0) {
			System.out.println(min);
		} else {
			for (int i = min / 2; i >= 1; i--) {
				if (a % i == 0 && b % i == 0) {
					System.out.println(i);
					break;
				}
			}
		}

		// LCM

		a = 17;
		b = 19;
		int max = (a > b) ? a : b;
		int lcm = max, u = 2;
		while (true) {
			if (lcm % a == 0 && lcm % b == 0) {
				System.out.println(lcm);
				break;
			}
			lcm = max * u++;
		}

		// LCM OF 4 NUMBERS

		int c = 12, d = 24;
		a = 36;
		b = 6;
		int m1 = (a > b) ? a : b;
		int m2 = (c > d) ? c : d;
		max = (m1 > m2) ? m1 : m2;
		lcm = max;
		u = 2;
		while (true) {
			if (lcm % a == 0 && lcm % b == 0 && lcm % c == 0 && lcm % d == 0) {
				System.out.println(lcm);
				break;
			}
			lcm = max * u++;
		}
	}
}
