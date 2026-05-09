package java_important_questions_with_answers_17.loops;

public class UpperCaseAlphaWithNumInVertical {

	public static void main(String[] args) {
		int a = 1;
		for (char c = 'A'; c <= 'Z'; c++, a++) {
			System.out.println(c + "\t" + a);
		}
	}
}