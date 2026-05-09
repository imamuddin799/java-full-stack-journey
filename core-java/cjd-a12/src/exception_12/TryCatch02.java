package exception_12;

public class TryCatch02 {

	public static void main(String[] args) {
		try {
			System.out.println("Try");
			System.out.println(10 / 0);
			System.out.println("Try Ends");
		} catch (ArithmeticException e) {
			System.out.println("Catch");
			System.out.println("Waste fellow we can't divide any value with zero");
			System.out.println(e);
			System.out.println("Catch Ends");
		}
	}
}
