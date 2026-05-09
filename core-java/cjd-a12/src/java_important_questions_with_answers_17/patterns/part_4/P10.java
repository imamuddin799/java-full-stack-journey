package java_important_questions_with_answers_17.patterns.part_4;

public class P10 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		int space = 0;
		int char1 = n;
		for (int i = 1; i <= row; i++) {
			char ch = 'e';
			for (int j = 1; j <= space; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= char1; j++) {
				System.out.print(ch--);
			}
			System.out.println();
			space++;
			char1--;
		}
	}
}