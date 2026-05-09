package java_important_questions_with_answers_17.if_else;

public class MidOf3Num {

	public static void main(String[] args) {
		int a = 10, b = 20, c = 30;
		System.out.println("Given numbers are A : " + a + ", B : " + b + ", C : " + c);
		if (a > b && a < c || a < b && a > c) {
			System.out.println("Middle of given 3 numbers : " + a);
		} else if (b > a && b < c || b < a && b > c) {
			System.out.println("Middle of given 3 numbers : " + b);
		} else {
			System.out.println("Middle of given 3 numbers : " + c);
		}
	}
}