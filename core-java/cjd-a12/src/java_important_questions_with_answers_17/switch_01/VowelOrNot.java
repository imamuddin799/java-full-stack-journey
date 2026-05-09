package java_important_questions_with_answers_17.switch_01;

public class VowelOrNot {

	public static void main(String[] args) {
		char ch = 'A';
		switch (ch) {
		case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U':
			System.out.println("Given character is a Vowel : '" + ch + "'");
			break;
		default:
			System.out.println("Given character is not a Vowel : '" + ch + "'");
		}
	}
}