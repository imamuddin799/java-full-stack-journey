package recursion_07.oct_22;

public class ReverseOfNum02 {

	public static int reverse(int n, int rev){
		if(n!=0){
			rev=rev*10+(n%10);
			return reverse(n/10,rev);
		}
		else{
			return rev;
		}
	}
	public static void main(String[] args){
		System.out.println(reverse(13345, 0));
	}
}
