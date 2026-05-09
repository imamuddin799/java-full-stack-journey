package class_members_06.static_member_01.static_variable_01.oct_18;

public class B04 {

	static boolean b;
	public static void main(String[] args){
		System.out.println(b);//false
		System.out.println(a);//35
		int a=10;
		System.out.println(a);//10
		boolean b=true;
		System.out.println(b);//true
		System.out.println(B04.a);//35
		System.out.println(B04.b);//false
	}
	static int a=35;
}
