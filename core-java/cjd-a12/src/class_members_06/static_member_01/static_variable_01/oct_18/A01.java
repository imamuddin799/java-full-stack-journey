package class_members_06.static_member_01.static_variable_01.oct_18;

public class A01 {

	static int a;
	//static double a;//CTE
	public static void main(String[] args){
		int b;
		//System.out.println(b);	//CTE:Compile Time Error
		System.out.println(a);//0
	}
}