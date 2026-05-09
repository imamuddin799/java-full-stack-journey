package java_important_questions_with_answers_17.recursion;

public class Natural1to10 {

	public static void natural1to10(int n) {
		if (n <= 10) {
			System.out.println(n);
			natural1to10(n + 1);
		}
	}

	public static void main(String[] args) {
		natural1to10(1);
	}
}