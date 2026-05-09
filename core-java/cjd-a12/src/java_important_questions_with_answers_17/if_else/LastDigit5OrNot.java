package java_important_questions_with_answers_17.if_else;

public class LastDigit5OrNot {

	public static void main(String[] args) {
		int n = 25;
		System.out.println("Given numbers N : " + n);
		if (n % 10 == 5) {
			System.out.println("Last digit of given number is 5 (" + n + ")");
		} else {
			System.out.println("Last digit of given number is not 5 (" + n + ")");
		}
	}
}