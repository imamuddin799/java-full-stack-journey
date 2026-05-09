package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P15 {

	public static void main(String[] args) {
		int n = 4;
		int row = n;
		int column = row;
		char ch = 'i';
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= column; j++) {
				System.out.print(ch--);
				if (ch < 'a') {
					ch = 'i';
				}
			}
			System.out.println();
		}
	}
}