package class_members_06.non_static_member_02.non_static_initializer_block_02;

public class OctTwentyFive03 {

	static int a = 10;
	int b = 20;
	static {
		System.out.println("SIB Starts");
		System.out.println(a);
		int a = 100;
		System.out.println(a);
		System.out.println(OctTwentyFive03.a);
		OctTwentyFive03.a = 200;
		System.out.println("SIB Ends");
	}
	{
		System.out.println("IIB Starts");
		System.out.println(b);
		b = 500;
		int b = 40;
		System.out.println(b);
		System.out.println(this.b);
		this.b = 250;
		System.out.println("IIB Ends");
	}

	public static void main(String[] args) {
		System.out.println("Main Starts");
		OctTwentyFive03 ob = new OctTwentyFive03();
		OctTwentyFive03 ob1 = new OctTwentyFive03();
		System.out.println(ob.a);
		System.out.println(ob.b);
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		ob.a = 1000;
		ob.b = 2000;
		System.out.println(ob.a);
		System.out.println(ob.b);
		System.out.println(ob1.a);
		System.out.println(ob1.b);
		System.out.println("Main Ends");
	}
}
