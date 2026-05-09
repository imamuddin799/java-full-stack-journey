package java_important_questions_with_answers_17.basic_programs;

public class LargestOfTwoNum {

	public static void main(String[] args) {
		int a = 15, b = 25;
		System.out.println("Given Numbers A : " + a + ", B : " + b);
		int result = a > b ? a : b;
		System.out.println("Largest of given two numbers : " + result);
	}
}
