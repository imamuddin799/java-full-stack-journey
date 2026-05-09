package controlflow_02.loops_03.while_01;

public class SepNinteen01 {

	public static void main(String[] args) {

		// DATE-19/09/2024

		// PRINT MESSAGE "HI" 100 TIMES

		int i = 1;
		while (i <= 100) {
			System.out.println("HI");
			i++;
		}

		// PRINT 1ST 10 NATURAL NUMBERS

		i = 1;
		while (i <= 10) {
			System.out.println(i++);
		}

		// PRINT ALPHABET 'A' TO 'Z'

		char ch = 'A';
		while (ch <= 'Z') {
			System.out.println(ch++);
		}

		// PRINT ALPHABET 'z' to 'a'

		ch = 'z';
		while (ch >= 'a') {
			System.out.println(ch--);
		}

		// PRINT Aa Ba ... Zz

		char upperCase = 'A';
		char lowerCase = 'a';
		int digit = 0;

		while (upperCase <= 'Z') {
			System.out.println(upperCase++ + " " + lowerCase++);
		}

		// PRINT A | 1, B | 2, .... Z | 26

		upperCase = 'A';
		digit = 1;
		while (digit <= 26) {
			System.out.println(upperCase++ + " | " + digit++);
		}

		// PRINT A a 1, B b 2, .... Z z 26

		upperCase = 'A';
		lowerCase = 'a';
		digit = 1;
		while (lowerCase <= 'z') {
			System.out.println(upperCase++ + " " + lowerCase++ + " " + digit++);
		}

		// PRINT a $ Z, b $ Y, .... z $ A

		lowerCase = 'a';
		upperCase = 'Z';
		while (lowerCase <= 'z' && upperCase >= 'A') {
			System.out.println(lowerCase++ + " $ " + upperCase--);
		}

		// PRINT 10 TO 20

		int num = 10;
		while (num <= 20) {
			System.out.println(num++);
		}

		// PRINT 200 TO 180

		num = 200;
		while (num >= 180) {
			System.out.println(num--);
		}

		// PRINT EVEN 50 TO 60

		num = 50;
		while (num <= 60) {
			if (num % 2 == 0)
				System.out.println(num);
			num++;
		}

		// PRINT ODD 100 TO 80

		num = 100;
		while (num >= 80) {
			if (num % 2 != 0)
				System.out.println(num);
			num--;
		}
	}
}
