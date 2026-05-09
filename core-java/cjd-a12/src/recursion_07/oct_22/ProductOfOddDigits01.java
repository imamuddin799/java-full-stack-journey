package recursion_07.oct_22;

public class ProductOfOddDigits01 {

	public static int product(int n){
		if(n!=0){
			if(n%2==1)
				return (n%10) * product(n/10);
			else
				return product(n/10);
		}
		return 1;
	}
	public static void main(String[] args){
		System.out.println(product(258613));
	}
}
