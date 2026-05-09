package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P9 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (i == 1 || j == 1 || i == row || j == column) {
					System.out.print('*');
				} else {
					System.out.print(' ');
				}
			}
			System.out.println();
		}
	}
}