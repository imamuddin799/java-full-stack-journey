package class_members_06.non_static_member_02.non_static_initializer_block_02;

public class OctTwentyFive01 {

	int a = 10;
	{
		System.out.println("IIB Starts");
		System.out.println(a);
		System.out.println("IIB Ends");
	}

	public static void main(String[] args) {
		System.out.println("Main Starts");
		OctTwentyFive01 ob = new OctTwentyFive01();
		System.out.println(ob.a);
		System.out.println("Main Ends");
	}
}
