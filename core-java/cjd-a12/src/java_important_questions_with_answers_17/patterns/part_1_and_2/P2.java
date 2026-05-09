package java_important_questions_with_answers_17.patterns.part_1_and_2;

public class P2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 4; i++) {
			for (int j = 1; j <= 4; j++) {
				if (i == 1 && j == 3 || i == 4 && j == 1) {
					System.out.print("%");
				} else {
					System.out.print("A");
				}
			}
			System.out.println();
		}
	}
}
