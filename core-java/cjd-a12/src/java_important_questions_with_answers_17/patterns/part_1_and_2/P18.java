package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P18 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		for (int i = 1; i <= row; i++) {
			char ch = 'A';
			for (int j = 1; j <= column; j++) {
				if (i % 2 == 0) {
					System.out.print(j);
				} else {
					System.out.print(ch++);
				}
			}
			System.out.println();
		}
	}
}