package java_important_questions_with_answers_17.patterns.part_5;

public class P1 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int space = n - 1;
		int star = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= star; j++) {
				System.out.print('*');
			}
			System.out.println();
			space--;
			star += 2;
		}
	}
}