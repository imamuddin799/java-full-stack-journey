package thread_16.jan_06;

public class PrintTable07 {

	public static void main(String[] args) {
		TableFive05 t5 = new TableFive05();
		TableSeven06 t7 = new TableSeven06();

		t5.start();
		t7.start();
	}
}
