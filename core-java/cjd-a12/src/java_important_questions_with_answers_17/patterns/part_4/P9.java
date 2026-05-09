package java_important_questions_with_answers_17.patterns.part_4;

public class P9 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int num = 1;
		char ch = 'a';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= i; j++) {
				if (j % 2 == 0) {
					System.out.print(ch++);
				} else {
					System.out.print(num++);
				}
			}
			System.out.println();
		}
	}
}