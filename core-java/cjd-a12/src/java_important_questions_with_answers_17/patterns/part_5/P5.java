package java_important_questions_with_answers_17.patterns.part_5;

public class P5 {

	public static void main(String[] args) {
		int n = 7;
		int row = n;
		int space = n / 2;
		int star = 1;
		int num = 1;
		for (int i = 1; i <= row; i++) {
			for (int j = 1; j <= space; j++) {
				System.out.print(' ');
			}
			for (int j = 1; j <= star; j++) {
				System.out.print(num);
			}
			System.out.println();
			if (i <= row / 2) {
				space--;
				star += 2;
				num++;
			} else {
				space++;
				star -= 2;
				num--;
			}
		}
	}
}