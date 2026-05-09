package method_overloading_05.oct_16;

public class Adding02 {

	public static void add(int a, int b) {
		System.out.println("1");
	}

	public static void add(double a, double b) {
		System.out.println("2");
	}

	public static void add(byte a, int b) {
		System.out.println("3");
	}

	public static void add(int a, int b, int c) {
		System.out.println("4");
	}

	public static void add(int a, double b) {
		System.out.println("5");
	}

	public static void main(String[] args) {
		add(2, 8);// 1
		add((byte) 5, 20);// 3
		add('d', 24);// 1
		add('a', 6.6);// 5
		add(90.6, 62);// 2
		add(1, 2, 3);// 4
		// add(1,2,3,4);//Compile Time Error
	}
}
