package thread_16.jan_06;

public class ThreadOne02 extends Thread {
	public void run() {
		long start = System.currentTimeMillis();
		Number01 n = new Number01();
		for (int i = 1; i <= 10000000; i++) {
			if (n.isStrong(i)) {
				System.out.println("Given Number is Strong number " + i);
			}
//			else {
//				System.out.println("Given Number is not Strong number");
//			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken by Strong execution : " + (end - start));

	}
}