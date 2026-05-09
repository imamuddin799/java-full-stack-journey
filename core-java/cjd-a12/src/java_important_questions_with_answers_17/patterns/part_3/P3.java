package java_important_questions_with_answers_17.patterns.part_3;

public class P3 {

	public static void main(String[] args) {
		int n = 5;
		int row = n - 1;
		int column = n;
		int num = 1;
		char ch = 'a';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (j == 1 || j == column) {
					System.out.print(ch++);
				} else if (j % 2 == 0) {
					System.out.print(num++);
				} else {
					System.out.print('+');
				}
			}
			System.out.println();
		}
	}
}