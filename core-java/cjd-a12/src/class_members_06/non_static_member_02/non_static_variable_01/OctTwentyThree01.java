package class_members_06.non_static_member_02.non_static_variable_01;

public class OctTwentyThree01 {

	int a;
	int b = 30;
	public static void main(String[] args){
		OctTwentyThree01 ob = new OctTwentyThree01();
		System.out.println(ob.a);
		System.out.println(ob.b);
		ob.a = 200;
		System.out.println(ob.a);
	}
}
