package thread_16.jan_06;

public class PrintStrongAndArmStrong04 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		ThreadOne02 t1 = new ThreadOne02();
		ThreadTwo03 t2 = new ThreadTwo03();
		t1.start();
		t2.start();
		long endtime = System.currentTimeMillis();
		long t = endtime - startTime;
		System.out.println("Total time : " + t);
	}
}
