package java_important_questions_with_answers_17.loops;

public class QuotientWithoutDivisorOp {

	public static void main(String[] args) {
		int dividend = 850, t = dividend;
		int divisor = 58;
		int quotient = 0;
		while (dividend >= divisor) {
			quotient++;
			dividend -= divisor;
		}
		dividend = t;
		System.out.println("The Quotient Of " + dividend + " divided by " + divisor + " is : " + quotient);
	}
}