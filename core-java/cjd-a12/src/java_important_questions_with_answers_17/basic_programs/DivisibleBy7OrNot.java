package java_important_questions_with_answers_17.basic_programs;

public class DivisibleBy7OrNot {

	public static void main(String[] args) {
		int n = 28;
		System.out.println("True if Divisible by 7 False if not Divisible by 7");
		System.out.println(n % 7 == 0 ? true : false);

		String res = n % 7 == 0 ? n + " is Divisible by 7" : n + " is not Divisible by 7";
		System.out.println(res);
	}
}