package java_important_questions_with_answers_17.loops;

public class EvenNumBetweenMAndN {

	public static void main(String[] args) {
		int m = 5, n = 100;
		System.out.println("Even Numbers between " + m + " " + n);
		for (int i = m; i <= n; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
	}
}