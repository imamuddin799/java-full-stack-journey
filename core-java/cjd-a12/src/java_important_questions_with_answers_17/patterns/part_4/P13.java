package java_important_questions_with_answers_17.patterns.part_4;

public class P13 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int num = 0;
		for (int i = 1; i <= row; i++) {
			num = num + i;
			for (int j = 1; j <= i; j++) {
				System.out.print(num--);
			}
			num = num + i;
			System.out.println();
		}
	}
}