package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P11 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		int num = n * 2;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (i == j || i + j == row + 1) {
					System.out.print(num--);
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}
}