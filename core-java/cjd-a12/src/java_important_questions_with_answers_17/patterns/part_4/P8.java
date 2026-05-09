package java_important_questions_with_answers_17.patterns.part_4;

public class P8 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		for (int i = 1; i <= row; i++) {
			int num = 1;
			char ch = 'a';
			for (int j = 1; j <= i; j++) {
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