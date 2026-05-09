package java_important_questions_with_answers_17.basic_programs;

public class SwapWithoutThirdVar {

	public static void main(String[] args) {
		int a = 10, b = 20;
		System.out.println("Before Swapping  A : " + a + ", B : " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("Swapping done  A : " + a + ", B : " + b);
	}
}