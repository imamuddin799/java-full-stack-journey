package java_important_questions_with_answers_17.patterns.part_4;

public class P5 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		char ch = 'a';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(ch++);
			}
			System.out.println();
		}
	}
}