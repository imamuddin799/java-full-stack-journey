package controlflow_02.switchcases02;

public class SepSeventeenAssignment02 {

	public static void main(String[] args) {

		// DATE-17/09/2024

		// GREETINGS ACCORDING TO TIME

		int hour = 24;
		switch (hour) {
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
			System.out.println("GOOD MORNING.!!!");
			break;
		case 12:
		case 13:
		case 14:
		case 15:
		case 16:
			System.out.println("GOOD AFTERNOON.!!!");
			break;
		case 17:
		case 18:
		case 19:
			System.out.println("GOOD EVENING.!!!");
			break;
		case 20:
		case 21:
		case 22:
		case 23:
		case 24:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("GOOD NIGHT.!!!");
			break;
		default:
			System.out.println("NOT A VALID HOUR.!!!");
		}
		/**
		 * for(int hour=1; hour<=24; hour++){ System.out.println("FOR HOUR : "+hour);
		 * switch(hour){ case 6 : case 7 : case 8 : case 9 : case 10 : case 11 :
		 * System.out.println("GOOD MORNING.!!!"); break; case 12 : case 13 : case 14 :
		 * case 15 : case 16 : System.out.println("GOOD AFTERNOON.!!!"); break; case 17
		 * : case 18 : case 19 : System.out.println("GOOD EVENING.!!!"); break; case 20
		 * : case 21 : case 22 : case 23 : case 24 : case 1 : case 2 : case 3 : case 4 :
		 * case 5 : System.out.println("GOOD NIGHT.!!!"); break; default :
		 * System.out.println("NOT A VALID HOUR.!!!"); } System.out.println(); }
		 */
	}
}
