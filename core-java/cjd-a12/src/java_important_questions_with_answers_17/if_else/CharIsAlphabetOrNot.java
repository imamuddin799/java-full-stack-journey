package java_important_questions_with_answers_17.if_else;

public class CharIsAlphabetOrNot {

	public static void main(String[] args) {
		char ch = ' ';
		System.out.println("Given Character is : '" + ch + "'");
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') {
			System.out.println(ch + " is an Alphabet");
		} else {
			System.out.println("'" + ch + "' is not an Alphabet");
		}
	}
}