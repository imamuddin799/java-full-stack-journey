package java_important_questions_with_answers_17.patterns.part_3;

public class P8 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int column = row;
		int num = 1;
		char ch = 'A';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				if (i == row / 2 + 1 || j == column / 2 + 1) {
					System.out.print('#');
				} else if (j % 2 == 0) {
					System.out.print(ch++);
				} else {
					System.out.print(num++);
				}
			}
			System.out.println();
		}
	}
}