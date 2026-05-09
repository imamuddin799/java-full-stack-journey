package java_important_questions_with_answers_17.patterns.part_4;

public class P11 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int star = n;
		for (int i = 1; i <= row; i++) {
			int num = n;
			char ch = 'a';
			for (int j = 1; j <= star; j++) {
				if (i % 2 == 0) {
					System.out.print(ch++);
				} else {
					System.out.print(num--);
				}
			}
			System.out.println();
			star--;
		}
	}
}