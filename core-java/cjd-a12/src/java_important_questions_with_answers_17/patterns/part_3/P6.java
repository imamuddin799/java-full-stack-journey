package java_important_questions_with_answers_17.patterns.part_3;

public class P6 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int column = row - 1;
		int num = 1;
		char ch = 'z';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (j % 2 == 0) {
					System.out.print(ch--);
				} else {
					System.out.print(num++);
					if (num > 9) {
						num = 1;
					}
				}
			}
			System.out.println();
		}
	}
}