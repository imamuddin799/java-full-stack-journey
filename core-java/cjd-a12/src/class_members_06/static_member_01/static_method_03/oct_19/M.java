package class_members_06.static_member_01.static_method_03.oct_19;

public class M {

	static int a = 10;

	public static void m1() {
		System.out.println("M1 Starts");
		System.out.println(a);
		System.out.println(b);
		a = 50;
		b = 100;
		System.out.println("M1 Ends");
	}

	static int b = 20;

	public static void main(String[] args) {
		System.out.println("Main Starts");
		System.out.println(a);
		System.out.println(b);
		m1();
		System.out.println(a);
		System.out.println(b);
		System.out.println("Main Ends");
	}
}
