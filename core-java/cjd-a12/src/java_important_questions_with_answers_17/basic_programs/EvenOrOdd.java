package java_important_questions_with_answers_17.basic_programs;

public class EvenOrOdd {

	public static void main(String[] args) {
		int n = 23;
		System.out.println("True if Even False if Odd");
		System.out.println(n % 2 == 0 ? true : false);

		// 2nd way
		String res = n % 2 == 0 ? n + " is Even" : n + " is Odd";
		System.out.println(res);
	}
}
