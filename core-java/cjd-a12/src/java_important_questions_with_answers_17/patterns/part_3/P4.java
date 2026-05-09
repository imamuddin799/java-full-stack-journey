package java_important_questions_with_answers_17.patterns.part_3;

public class P4 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int column = row;
		int num = 1;
		char ch = 'a';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (j % 2 == 1) {
					if (i == row && j == 3) {
						System.out.print('+');
					} else {
						System.out.print(ch++);
					}
					if (ch > 'l') {
						ch = 'i';
					}
				} else {
					System.out.print(num++);
				}
			}
			System.out.println();
		}
	}
}