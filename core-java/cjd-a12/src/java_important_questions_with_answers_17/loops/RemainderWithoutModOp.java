package java_important_questions_with_answers_17.loops;

public class RemainderWithoutModOp {

	public static void main(String[] args) {
		int dividend = 84, t = dividend;
		int divisor = 52;
		while (dividend >= divisor) {
			dividend -= divisor;
		}
		int remainder = dividend;
		dividend = t;
		System.out.println("The Quotient Of " + dividend + " divided by " + divisor + " is : " + remainder);
	}
}