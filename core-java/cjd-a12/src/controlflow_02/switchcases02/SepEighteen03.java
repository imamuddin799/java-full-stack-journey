package controlflow_02.switchcases02;

public class SepEighteen03 {

	public static void main(String[] args) {

		// DATE-18/09/2024

		int n = 4;
		switch (n) {
		default:
			System.out.println("def");
		case 1:
			System.out.println(1);
			break;
		case 2:
			System.out.println(2);
		case 3:
			System.out.println(3);
		}

		// SQUARE OF GIVEN NUMBER'S LAST DIGIT

		int num = 567;
		int lastDigit = num % 10;
		int square = lastDigit * lastDigit;
		System.out.println(
				"Given Number is : " + num + " , Last Digit is : " + lastDigit + " and Square of it is : " + square);

		// DOG HOUSE

		int hour = 24;
		boolean bark = true;
		switch (hour) {
		case 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18 -> System.out.println("SAFE");
		case 1, 2, 3, 4, 5, 19, 20, 21, 22, 23, 24 -> {
			if (bark) {
				System.out.println("DANGER");
			} else {
				System.out.println("SAFE");
			}
		}
		default -> System.out.println("INVALID HOUR");
		}

		// OR

		int hours = 19;
		boolean barks = true;
		if (hours >= 1 && hours <= 24) {
			if (barks && hours <= 6 || hours >= 19) {
				System.out.println("DANGER");
			} else {
				System.out.println("SAFE");
			}
		} else {
			System.out.println("INVALID HOURS");
		}

		// GIVEN CHARACTER IS UPPERCASE ALPHABET OR LOWERCASE ALPHABET OR DIGIT OR
		// SPECIAL CHARACTER
		// IF ALPHABET CHECK VOWEL OR CONSONANT

		char ch = 'I';
		if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
			if (ch >= 'A' && ch <= 'Z') {
				System.out.println("UPPERCASE ALPHABET");
				if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
					System.out.println("VOWEL");
				} else {
					System.out.println("CONSONANT");
				}
			} else {
				System.out.println("LOWERCASE ALPHABET");
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
					System.out.println("VOWEL");
				} else {
					System.out.println("CONSONANT");
				}
			}
		} else if (ch >= '0' && ch <= '9') {
			System.out.println("DIGIT : " + ch);
		} else {
			System.out.println("SPECIAL CHARACTER ");
		}

		// TESTING

		int ch127 = 127;
		char ch1 = (char) ch127;
		for (ch = ' '; ch <= ch1; ch++) {

			// for(ch=' ';ch<='~';ch++){
			System.out.println("INPUT CHARACTER IS : '" + ch + "'");
			if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
				if (ch >= 'A' && ch <= 'Z') {
					System.out.println("UPPERCASE ALPHABET");
					if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
						System.out.println("VOWEL");
					} else {
						System.out.println("CONSONANT");
					}
				} else {
					System.out.println("LOWERCASE ALPHABET");
					if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
						System.out.println("VOWEL");
					} else {
						System.out.println("CONSONANT");
					}
				}
			} else if (ch >= '0' && ch <= '9') {
				System.out.println("DIGIT : " + ch);
			} else {
				System.out.println("SPECIAL CHARACTER ");
			}
			System.out.println();
		}
	}
}
