package java_important_questions_with_answers_17.switch_01;

public class RemaingDayName {

	public static void main(String[] args) {
		int n = 8;
		switch (n) {
		case 1:
			System.out.println("Sunday");
		case 2:
			System.out.println("Monday");
		case 3:
			System.out.println("Tuesday");
		case 4:
			System.out.println("Wednesday");
		case 5:
			System.out.println("Thursday");
		case 6:
			System.out.println("Friday");
		case 7:
			System.out.println("Saturday");
			break;
		default:
			System.out.println("Invalid Input.!!!");
		}
	}
}