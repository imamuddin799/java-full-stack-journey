package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P19 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		int num = 1;
		char ch = 'a';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (i % 2 == 0) {
					System.out.print(ch++);
				} else {
					System.out.print(num++);
				}
			}
			System.out.println();
		}
	}
}