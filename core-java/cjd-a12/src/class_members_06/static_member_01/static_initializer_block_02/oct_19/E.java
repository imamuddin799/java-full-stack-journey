package class_members_06.static_member_01.static_initializer_block_02.oct_19;

public class E {

	static int a = 10;
	static {
		System.out.println("SIB1 Starts");
		System.out.println(a);
		System.out.println(E.b);
		E.b = 50;
		a = 500;
		System.out.println("SIB1 Ends");
	}
	static int b = 30;
	static {
		System.out.println("SIB2 Starts");
		System.out.println(a);
		System.out.println(b);
		a = 150;
		b = 250;
		System.out.println("SIB2 Ends");
	}

	public static void main(String[] args) {
		System.out.println("Main Starts");
		System.out.println(a);
		System.out.println(b);
		System.out.println("Main Ends");
	}
}
