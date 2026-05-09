package class_members_06.static_member_01.static_method_03.oct_19;

public class OctNineteenAssignment02 {

	static int b = 10;

	public static void main(String[] args) {
		System.out.println("Main Starts");
		System.out.println(a);
		System.out.println(b);
		a = 1500;
		b = 2000;
		m1();
		System.out.println(a);
		System.out.println(b);
		System.out.println("Main Ends");
	}

	static int a = 20;
	static {
		System.out.println("SIB1 Starts");
		System.out.println(a);
		System.out.println(b);
		m1();
		System.out.println(a);
		System.out.println(b);
		a = 100;
		b = 200;
		System.out.println("SIB1 Ends");
	}

	public static void m1() {
		System.out.println("M1 Starts");
		System.out.println(a);
		System.out.println(b);
		a = 150;
		b = 250;
		System.out.println("M1 Ends");
	}

	static {
		System.out.println("SIB2 Starts");
		System.out.println(a);
		System.out.println(b);
		m1();
		System.out.println(a);
		System.out.println(b);
		a = 350;
		b = 450;
		System.out.println("SIB2 Ends");
	}
}
