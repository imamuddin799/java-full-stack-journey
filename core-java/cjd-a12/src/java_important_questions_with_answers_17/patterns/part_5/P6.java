package java_important_questions_with_answers_17.patterns.part_5;

public class P6 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int space = n - 1;
		int star = 1;
		for (int i = 1; i <= row; i++) {
			char ch = 'A';
			for (int j = 1; j <= space; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= star; j++) {
				System.out.print(ch);
				if (j <= star / 2)
					ch++;
				else
					ch--;
			}
			System.out.println();
			space--;
			star += 2;
		}
	}
}