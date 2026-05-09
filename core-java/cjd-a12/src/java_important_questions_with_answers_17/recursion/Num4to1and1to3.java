package java_important_questions_with_answers_17.recursion;

public class Num4to1and1to3 {

	public static void num4to1and1to3(int n, int a) {
		if (n >= 1 || a <= 3) {
			System.out.println(n + "\t" + a);
			num4to1and1to3(n - 1, a + 1);
		}
	}

	public static void main(String[] args) {
		num4to1and1to3(4, 1);
	}
}