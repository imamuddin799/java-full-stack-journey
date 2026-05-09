package thread_16.jan_06.assignment;

public class PrintTables03 {

	public static void main(String[] args) {
		TableFive01 t01 = new TableFive01();
		TableSeven02 t02 = new TableSeven02();
		Thread th01 = new Thread(t01);
		Thread th02 = new Thread(t02);
		th01.start();
		th02.start();

		Runnable t1 = () -> {
			for (int i = 1; i <= 20; i++) {
				System.out.println("5 * " + i + " = " + i * 5);
			}
		};

		Runnable t2 = () -> {
			for (int i = 1; i <= 20; i++) {
				System.out.println("7 * " + i + " = " + i * 7);
			}
		};

		Thread th1 = new Thread(t1);
		Thread th2 = new Thread(t2);

		th1.start();
		th2.start();
	}
}