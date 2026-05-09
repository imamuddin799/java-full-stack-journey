package method_overloading_05.oct_16;

public class CompileTimeBinding03 {

	public static void m1() {
		System.out.println("m1");
	}

	public static void m2(int a, int b) {
		System.out.println("m2");
	}

	public static void m3(float b) {
		System.out.println("m3");
	}

	public static void m4(byte b) {
		System.out.println("m4");
	}

	public static void main(String[] args) {
		m1(); // m1
		// m1(3); actual and formal argument lists differ in length
		m2(4, 6); // m2
		m2('a', 7); // m2
		// m2(3.4,6); argument mismatch
		// m3(2.2); argument mismatch
		m3(4.7f); // m3
		// m4(12); argument mismatch
		m4((byte) 12); // m4
	}
}
