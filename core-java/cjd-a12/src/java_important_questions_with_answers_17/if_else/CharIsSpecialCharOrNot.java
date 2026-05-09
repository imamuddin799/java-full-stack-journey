package java_important_questions_with_answers_17.if_else;

public class CharIsSpecialCharOrNot {

	public static void main(String[] args) {
		char ch = '^';
		System.out.println("Given Character is : '" + ch + "'");
		if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch >= '0' && ch <= '9') {
			System.out.println(ch + " is not a Special Character");
		} else {
			System.out.println("'" + ch + "' is a Special Character");
		}
	}
}