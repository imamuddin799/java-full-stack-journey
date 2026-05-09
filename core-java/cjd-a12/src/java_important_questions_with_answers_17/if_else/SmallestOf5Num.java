package java_important_questions_with_answers_17.if_else;

public class SmallestOf5Num {

	public static void main(String[] args) {
		int a = 10, b = 20, c = 30, d = 40, e = 5;
		System.out.println("Given numbers are A : " + a + ", B : " + b + ", C : " + c + ", D : " + d + ", E : " + e);
		if (a < b && a < c && a < d && a < e) {
			System.out.println("Smallest of given 5 numbers : " + a);
		} else if (b < c && b < d && b < e) {
			System.out.println("Smallest of given 5 numbers : " + b);
		} else if (c < d && c < e) {
			System.out.println("Smallest of given 5 numbers : " + c);
		} else if (d < e) {
			System.out.println("Smallest of given 5 numbers : " + d);
		} else {
			System.out.println("Smallest of given 5 numbers : " + e);
		}
	}
}