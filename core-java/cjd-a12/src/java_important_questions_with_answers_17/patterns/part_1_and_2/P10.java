package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P10 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int column = row;
		char ch = 'a';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (i == j || i + j == row + 1) {
					if (ch == 'e') {
						ch++;
					}
					System.out.print(ch++);
				} else {
					System.out.print('*');
				}
			}
			System.out.println();
		}
	}
}