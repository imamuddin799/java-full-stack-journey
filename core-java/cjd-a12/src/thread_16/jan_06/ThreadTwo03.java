package thread_16.jan_06;

public class ThreadTwo03 extends Thread {

	public void run() {
		long start = System.currentTimeMillis();
		Number01 n = new Number01();
		for (int i = 1; i <= 10000000; i++) {
			if (n.isArmStrong(i)) {
				System.out.println("Given Number is ArmStrong number " + i);
			}
//			else {
//				System.out.println("Given Number is not ArmStrong number");
//			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Time taken by ArmStrong execution : " + (end - start));
	}
}
