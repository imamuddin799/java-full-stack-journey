package java_important_questions_with_answers_17.switch_01;

public class SeasonName {

	public static void main(String[] args) {
		int n = 1;
		switch (n) {
		case 1, 2, 12:
			System.out.println("Winter");
			break;
		case 3, 4, 5:
			System.out.println("Summer");
			break;
		case 6, 7, 8:
			System.out.println("Rainy");
			break;
		case 9, 10, 11:
			System.out.println("Spring");
			break;
		default:
			System.out.println("Invalid Input.!!!");
		}
	}
}