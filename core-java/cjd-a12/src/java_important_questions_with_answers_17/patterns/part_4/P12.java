package java_important_questions_with_answers_17.patterns.part_4;

public class P12 {

	public static void main(String[] args) {
		int n = 5;
		int row = n;
		for (int i = 1; i <= row; i++) {
			char ch = 'e';
			for (int j = 1; j <= i; j++) {
				System.out.print(ch--);
			}
			System.out.println();
		}
	}
}