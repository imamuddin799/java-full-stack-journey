package arrays_10.problems_03;

public class LongestIncreasingSubsequence01 {

	public static void main(String[] args) {
		int a[] = { 2, 5, 7, 3, 8, 10, 11, 18, 21, 5, 3, 8 };
//		int a[] = {8,7,9,5,11,8,12};
		int longIncrSubseq = -1;
		int f = -1;
		int l = -1;
		for (int i = 0; i < a.length; i++) {
			int max = Integer.MIN_VALUE;
			int c = 0;
			for (int j = i; j < a.length; j++) {
				if (a[j] > max) {
					max = a[j];
					c++;
					if (c > longIncrSubseq) {
						longIncrSubseq = c;
						f = i;
						l = j;
					}
//					System.out.println("j "+ j);
				} else {
					i = j - 1;
					break;
				}
			}
//			System.out.println("i "+i);
		}
		System.out.println("The Longest Increasing Sequence is from index " + f + " to " + l + " i.e,. : "
				+ longIncrSubseq + " Elements.");
		System.out.print("The sequence is : ");
		for (int i = f; i <= l; i++) {
			System.out.print(a[i] + " ");
		}

//		int a[] = {2, 5, 7, 3, 8, 10, 11, 18, 21, 5, 3, 22};
//		int longIncrSubseq = -1;
//		int f = -1;
//		int l = -1;
//		for (int i = 0; i < a.length; i++) {
//			int max = Integer.MIN_VALUE;
//			int c = 0;
//			for (int j = i; j < a.length; j++) {
//				if (a[j] > max) {
//					max = a[j];
//					c++;
//					if(c > longIncrSubseq)
//						l = j;
////					System.out.println("\n\ni "+ i +" j "+ j +" long "+ longIncrSubseq +" f "+ f +" l "+ l +" max "+ max +" c "+ c);
//				}
//				else {
//					break;
//				}
//			}
//			if(longIncrSubseq < c) {
//				longIncrSubseq = c;
//				f = i;
//			}
//		}
//		System.out.println("The Longest Increasing Sequence is from index " + f + " to " + l + " i.e,. : "
//				+ longIncrSubseq + " Elements.");
//		System.out.println("The sequence is :");
//		for (int i = f; i <= l; i++) {
//			System.out.print(a[i] + " ");
//		}
	}
}
