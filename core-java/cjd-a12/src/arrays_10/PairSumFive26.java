package arrays_10;

public class PairSumFive26 {

	public static void main(String[] args) {
		int a[] = {4,7,6,-2,1,5,4,0,1};
		int occ[] = new int[a.length];
		int t = 5;
		for(int i = 0; i < a.length; i++) {
			for(int j = i + 1; j < a.length-1; j++) {
				if(a[i] + a[j] == t && occ[j] != 1 && occ[i] != 1) {
					occ[j] = 1;
					System.out.println(a[i] +", "+ a[j]);
				}
			}
		}
	}
}
