package java_important_questions_with_answers_17.patterns.part_3;

public class P5 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int column = row;
		for (int i = 1; i <= row; i++) {
			char ch = 'a';
			for (int j = 1; j <= column; j++) {
				if (i % 2 == 0) {
					System.out.print(ch++);
				} else {
					if (i == row / 2 + 1) {
						System.out.print('+');
					} else {
						System.out.print(j);
					}
				}
			}
			System.out.println();
		}
	}
}