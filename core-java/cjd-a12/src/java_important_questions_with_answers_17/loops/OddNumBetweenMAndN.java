package java_important_questions_with_answers_17.loops;

public class OddNumBetweenMAndN {

	public static void main(String[] args) {
		int m = 5, n = 30;
		System.out.println("Odd Numbers between " + m + " " + n);
		for (int i = m; i <= n; i++) {
			if (i % 2 == 1) {
				System.out.println(i);
			}
		}
	}
}