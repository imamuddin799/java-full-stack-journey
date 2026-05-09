package java_important_questions_with_answers_17.switch_01;

public class WorkingDayOrNot {

	public static void main(String[] args) {
		String day = "Friday";
		switch (day) {
		case "Sunday":
			System.out.println("Sunday is not a Working day");
			break;
		case "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday":
			System.out.println(day + " is a Working day");
			break;
		default:
			System.out.println("Invalid Input.!!!");
		}
	}
}