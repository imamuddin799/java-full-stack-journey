package class_members_06.non_static_member_02.non_static_method_03;

public class OctTwentyEight03 {

	static OctTwentyEight03 ob = new OctTwentyEight03();
	int a = 10;

	public void m1() {
		System.out.println("M1 Starts");
		System.out.println(this.a);
		this.a = 100;
		System.out.println("M1 Ends");
	}

	public static void m2() {
		System.out.println("M2 Starts");
		System.out.println(ob.a);
		ob.m1();
		System.out.println("M2 Ends");
	}

	public static void main(String[] args) {
		System.out.println("Main Starts");
		System.out.println(ob.a);
		ob.m1();
		System.out.println(ob.a);
		m2();
		System.out.println("Main Ends");
	}
}
