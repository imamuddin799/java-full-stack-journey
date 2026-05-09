package java_important_questions_with_answers_17.loops;

public class SumOfNaturalNumBetweenMAndN {

	public static void main(String[] args) {
		int m = 5, n = 10, sum = 0;
		for (int i = m; i <= n; i++) {
			sum += i;
		}
		System.out.println("Sum of Natural Numbers between " + m + " and " + n + " = " + sum);
	}
}