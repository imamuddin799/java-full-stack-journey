package java_important_questions_with_answers_17.basic_programs;

public class LargestOfThreeNum {

	public static void main(String[] args) {
		int a = 15, b = 25, c = 45;
		System.out.println("Given Numbers A : " + a + ", B : " + b + ", C : " + c);
		int result = (a > b) ? (a > c ? a : c) : (b > c ? b : c);
		System.out.println("Largest of given three numbers : " + result);
	}
}