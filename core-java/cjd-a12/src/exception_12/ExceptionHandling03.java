package exception_12;

public class ExceptionHandling03 {

	public static void main(String[] args) {
		int a[] = { 1, 23, 76, 5, 9, 0 };
		try {
			System.out.println("Try");
			System.out.println(a[10]);
			System.out.println("Try Ends");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Catch");
			System.out.println(e);
			System.out.println("Catch Ends");
		}

		try {
			System.out.println("Try2");
			System.out.println(1 / a[a.length - 1]);
			System.out.println("Try Ends");
		} catch (ArithmeticException e) {
			System.out.println("Catch2");
			System.out.println(e);
			System.out.println("Catch2 Ends");
		}
	}
}
