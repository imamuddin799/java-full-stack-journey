package java_important_questions_with_answers_17.basic_programs;

public class Swap {

	public static void main(String[] args) {
		int a = 10, b = 20, c;
		System.out.println("Before Swapping  A : " + a + ", B : " + b);
		c = a;
		a = b;
		b = c;
		System.out.println("Swapping Done  A : " + a + ", B : " + b);
	}
}