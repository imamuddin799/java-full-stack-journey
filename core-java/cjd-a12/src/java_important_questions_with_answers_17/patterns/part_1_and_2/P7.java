package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P7 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		int star1 = 0;
		char ch = 'a';
		int star2 = n;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= star1; j++) {
				System.out.print("*");
			}
			for (int j = 1; j <= column; j++) {
				if (i == j) {
					System.out.print(ch);
				}
			}
			for (int j = 1; j < star2; j++) {
				System.out.print("*");
			}
			System.out.println();
			star1++;
			star2--;
		}
	}
}