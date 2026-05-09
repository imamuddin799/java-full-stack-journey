package methods_03.oct_08;

public class PrimeNumber01 {

	// DATE-08-10-2024

	// FIRST LOGIC
	/**
	 * public static boolean prime(int n){
	 * 		int count=0;
	 * 		for(int i=1; i<=n; i++){
	 * 			if(n%i==0)
	 * 				count++;
	 * 		}
	 * 		if(count==2)
	 * 			return true;
	 * 		else
	 * 			return false;
	 * }
	 * 
	 * //SECOND LOGIC 
	 * public static boolean prime(int n){
	 * 		if(n<2) return false;
	 * 		int count=0;
	 * 		for(int i=2; i<=n/2; i++){
	 * 			if(n%i==0){ 
	 * 				count++;
	 * 				break;
	 * 			}
	 * 		} 
	 * 		return count==0;
	 * }
	 */
	// THIRD LOGIC
	public static boolean prime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 19;
		if (prime(n))
			System.out.println(n + " IS A PRIME NUMBER");
		else
			System.out.println(n + " IS NOT A PRIME NUMBER");
	}
}
