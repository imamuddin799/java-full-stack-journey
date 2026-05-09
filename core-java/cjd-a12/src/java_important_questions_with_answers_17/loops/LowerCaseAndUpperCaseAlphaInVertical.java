package java_important_questions_with_answers_17.loops;

public class LowerCaseAndUpperCaseAlphaInVertical {

	public static void main(String[] args) {
		for (char c = 'a', ch = 'A'; c <= 'z'; c++, ch++) {
			System.out.println(c + "\t" + ch);
		}
	}
}