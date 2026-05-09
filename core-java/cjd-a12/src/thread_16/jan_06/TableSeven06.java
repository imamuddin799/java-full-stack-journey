package thread_16.jan_06;

public class TableSeven06 extends Thread {
	
	public void run() {
		for (int i = 1; i <= 20; i++) {
			System.out.println("7 * " + i + " = " + i * 7);
		}
	}
}
