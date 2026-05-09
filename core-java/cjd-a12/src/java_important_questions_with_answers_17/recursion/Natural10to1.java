package java_important_questions_with_answers_17.recursion;

public class Natural10to1 {

	public static void natural10to1(int n) {
		if (n >= 1) {
			System.out.println(n);
			natural10to1(n - 1);
		}
	}

	public static void main(String[] args) {
		natural10to1(10);
	}
}