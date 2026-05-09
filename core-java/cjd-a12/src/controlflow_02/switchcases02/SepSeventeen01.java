package controlflow_02.switchcases02;

public class SepSeventeen01 {

	public static void main(String[] args) {

		// DATE-17/09/2024

		// CHARACTER IS VOWEL OR NOT

		char ch = 'i';
		switch (ch) {
		case 'a':
			System.out.println("Vowel");
			break;
		case 'e':
			System.out.println("Vowel");
			break;
		case 'i':
			System.out.println("Vowel");
			break;
		case 'o':
			System.out.println("Vowel");
			break;
		case 'u':
			System.out.println("Vowel");
			break;
		default:
			System.out.println("Not Vowel");
		}
		// OR

		ch = 'a';
		switch (ch) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println("Vowel");
			break;
		default:
			System.out.println("Not Vowel");
		}

		// SHOW DAY IF SOME INPUT(1-7)

		int dayNumber = 6;
		switch (dayNumber) {
		case 1:
			System.out.println("SUNDAY");
			break;
		case 2:
			System.out.println("MONDAY");
			break;
		case 3:
			System.out.println("TUESDAY");
			break;
		case 4:
			System.out.println("WEDNESDAY");
			break;
		case 5:
			System.out.println("THURSDAY");
			break;
		case 6:
			System.out.println("FRIDAY");
			break;
		case 7:
			System.out.println("SATURDAY");
			break;
		default:
			System.out.println("NOT A WEEK DAY.!!");
		}

		// SHOW MONTHS NUMBER ALONG WITH NUMBER DATES PRESENT IN IT

		String monthName = "MAY";
		switch (monthName) {
		case "JAN":
			System.out.println("1 --> 31 DAYS");
			break;
		case "FEB":
			System.out.println("2 --> 28/29 DAYS");
			break;
		case "MAR":
			System.out.println("3 --> 31 DAYS");
			break;
		case "APR":
			System.out.println("4 --> 30 DAYS");
			break;
		case "MAY":
			System.out.println("5 --> 31 DAYS");
			break;
		case "JUN":
			System.out.println("6 --> 30 DAYS");
			break;
		case "JUL":
			System.out.println("7 --> 31 DAYS");
			break;
		case "AUG":
			System.out.println("8 --> 31 DAYS");
			break;
		case "SEP":
			System.out.println("9 --> 30 DAYS");
			break;
		case "OCT":
			System.out.println("10 --> 31 DAYS");
			break;
		case "DEC":
			System.out.println("11 --> 30 DAYS");
			break;
		case "NOV":
			System.out.println("12 --> 31 DAYS");
			break;
		default:
			System.out.println("NOT A MONTH");
		}
	}
}
