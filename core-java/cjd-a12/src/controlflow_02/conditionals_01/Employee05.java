package controlflow_02.conditionals_01;

public class Employee05 {

	public static void main(String[] args) {

		// DATE-14/09/2024

		boolean weekday = false;
		boolean vacation = false;
		if (weekday && !vacation) {
			System.out.println("No Rest");
		} else {
			System.out.println("Rest");
		}
	}
}
