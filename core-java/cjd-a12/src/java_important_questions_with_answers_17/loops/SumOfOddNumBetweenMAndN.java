package java_important_questions_with_answers_17.loops;

public class SumOfOddNumBetweenMAndN {

	public static void main(String[] args) {
		int m = 5, n = 10, sum = 0;
		for (int i = m; i <= n; i++) {
			if (i % 2 == 1) {
				sum += i;
			}
		}
		System.out.println("Sum of Odd Numbers between " + m + " and " + n + " = " + sum);
	}
}