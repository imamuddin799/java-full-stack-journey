package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P14 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		int num = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				System.out.print(num++);
				if (num == 10) {
					num = 1;
				}
			}
			System.out.println();
		}
	}
}