package java_important_questions_with_answers_17.loops;

public class ProductOfEvenNumBetweenMAndN {

	public static void main(String[] args) {
		int m = 5, n = 10, product = 1;
		for (int i = m; i <= n; i++) {
			if (i % 2 == 0) {
				product *= i;
			}
		}
		System.out.println("Product of Even Numbers between " + m + " and " + n + " = " + product);
	}
}