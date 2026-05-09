package java_important_questions_with_answers_17.patterns.part_4;

public class P3 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int star = n;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= star; j++) {
				System.out.print('*');
			}
			System.out.println();
			star--;
		}
	}
}