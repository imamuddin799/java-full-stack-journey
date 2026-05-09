package class_members_06.non_static_member_02.non_static_method_03;

public class OctTwentyEight04 {

	OctTwentyEight04 ob = new OctTwentyEight04();	// We should not create object out side static areas otherwise we will get StackOverflowError
	public static void main(String[] args){
		OctTwentyEight04 ob1 = new OctTwentyEight04();
	}
}
