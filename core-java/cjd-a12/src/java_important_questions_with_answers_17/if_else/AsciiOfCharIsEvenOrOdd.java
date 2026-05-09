package java_important_questions_with_answers_17.if_else;

public class AsciiOfCharIsEvenOrOdd {

	public static void main(String[] args) {
		char ch = 'A';
		int ascii = (int) ch;
		System.out.println("Given Character is : '" + ch + "'");
		if (ascii % 2 == 0) {
			System.out.println("ASCII of given character is Even : " + ascii);
		} else {
			System.out.println("ASCII of given character is Odd : " + ascii);
		}
	}
}