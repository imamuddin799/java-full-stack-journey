package recursion_07.oct_21;

public class SumOfFirstFiveNum02 {

	public static int sum(int n){
		if(n>=1){
			return n + sum(n - 1);
		}
		return 0;
	}
	public static void main(String[] args){
		System.out.println(sum(5));
	}
}
