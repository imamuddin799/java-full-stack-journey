package java_important_questions_with_answers_17.loops;

public class TableWithoutMulOp {

	public static void main(String[] args) {
		int n = 2;
		for (int i = 1; i <= 10; i++) {
			int sum = 0, j = i;
			while (j != 0) {
				sum += n;
				j--;
			}
			System.out.println(n + " * " + i + " = " + sum);
		}
	}
}