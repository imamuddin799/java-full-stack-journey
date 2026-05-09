package arrays_10.problems_03;

public class MaxSumSubarray02 {

	public static void main(String[] args) {
//		int a[] = {7,-9,8,3,-4,5,2,-5,3};
//		int sum = 0;
//		int max = 0;
//		int f = 0;
//		int l = 0;
//		for(int i = 0; i < a.length; i++) {
//			sum = 0;
//			for(int j = i; j < a.length; j++) {
//				sum += a[j];
//				if(sum > max) {
//					max = sum;
//					f = i;
//					l = j;
//				}
//					
//			}
//		}
//		System.out.println("Sum : "+ sum +" Max : "+ max +" First : "+ f +" Last : "+ l);
//		for(int i = f; i <= l; i++) {
//			System.out.print(a[i] +" ");
//		}

		int a[] = { 7, -9, 8, 3, -4, 5, 2, -5, 3 };
		int max = 0;
		int f = -1;
		int l = -1;
		for (int i = 0; i < a.length; i++) {
			int sum = 0;
			for (int j = i; j < a.length; j++) {
				sum += a[j];
				if (sum > max) {
					max = sum;
					f = i;
					l = j;
				}

			}
		}
		System.out.println("Max : " + max + " First : " + f + " Last : " + l);
		for (int i = f; i <= l; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
