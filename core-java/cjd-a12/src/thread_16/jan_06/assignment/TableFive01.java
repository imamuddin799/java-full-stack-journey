package thread_16.jan_06.assignment;

public class TableFive01 implements Runnable {

	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println("5 * " + i + " = " + i * 5);
		}
	}
}