package controlflow_02.loops_03.number_program_05;

public class OctFour05 {

	public static void main(String[] args) {

		// DATE-04/10/2024

		// FORM A NUMBER USING ODD POSITION DIGITS

		int on = 57328, t = on; // on=OriginalNumber
		int n = on, c = 0, p = 1, res = 0;
		while (t != 0) {
			c++;
			t /= 10;
		}
		while (n != 0) {
			if (c % 2 != 0) {
				int r = n % 10;
				res = p * r + res;
				p *= 10;
			}
			n /= 10;
			c--;
		}
		System.out.println(res);

		// FIND SUM OF DIGIT UNTIL WE GET SINGLE DIGIT
		n = 328;
		int sum = 0;
		while (n > 9) {
			sum = 0;
			while (n != 0) {
				int r = n % 10;
				sum = sum + r;
				n = n / 10;
			}
			n = sum;
		}
		System.out.println(n);

		// FIND SUM OF SQUARE OF EACH DIGIT UNTIL WE GET EITHER 1 OR 4 IF 1 PRINT HAPPY
		// ELSE PRINT NOT HAPPY

		n = 49;
		sum = 0;
		while (n != 1 && n != 4) {
			sum = 0;
			while (n != 0) {
				int r = n % 10;
				sum = r * r + sum;
				n /= 10;
			}
			n = sum;
		}
		if (n == 1)
			System.out.println("Happy.!!!");
		else
			System.out.println("Not Happy.!!!");
	}
}
