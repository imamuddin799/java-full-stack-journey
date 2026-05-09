package arrays_10;

public class RightGreater12 {

//	public static void main(String[] args) {
//	int a[] = {15,21,5,8,7,2};
//	int res[] = new int[a.length-1];
//	int k = 0;
//	
//	for(int i = 0; i < a.length; i++) {
//		int max = Integer.MIN_VALUE;
//		for(int j = i+1; j < a.length; j++) {
//			int update = j;
//			if(a[update] > max) {
//				max = a[update];
//				System.out.println(max +" a[j] "+ a[j]);
////				res[k] = a[i];
//			}
//			else {
////				max = max;
//				System.out.println(max +"  "+ max);
////				res[k] = a[j];
//			}
//		}
//		if(k < res.length)
//			res[k++] = max;
//		
//	}
//	
//	for(int i : res) {
//		System.out.print(i +" ");
//	}
//}

//public static void main(String[] args) {
//	
//	//Given array
//	int a[] = {15, 21, 5, 8, 7, 2};
//			  //{21, 8, 8, 7, 2}
//	//Creating result array
//	int res[] = new int[a.length-1];	//{0,0,0,0,0}
//	
//	//To iterate result array
//	int k = 0;
//	
//	//Iterating given array from to 0 to end
//	for(int i = 0; i < a.length; i++) {
//		
//		//To find max from given array but initializing by the lowest integer value
//		int max = Integer.MIN_VALUE;
//		
//		//Iterating given array from index 1 to end
//		for(int j = i + 1; j < a.length; j++) {
//			
//			//Storing j is update so that it could not give any exception
//			int update = j;
//			
//			//Checking which value is greater from the right of the ith index.
//			if(a[update] > max)
//				max = a[update];
//		}
//		
//		//Storing in result and incrementing k by 1 after using the value
//		if(k < res.length)
//			res[k++] = max;	//{21, 8, 8, 7, 2}
//	}
//	
//	//Displaying the result array
//	for(int i : res)
//		System.out.print(i +" ");
//	System.out.println("\n"+ Integer.MIN_VALUE);
//}
//}

//public static void main(String[] args) {
//	int a[] = {15, 21, 5, 8, 7, 2};
//	int res[] = new int[a.length-1];
//	int k = 0;
//	for(int i = 1; i < a.length; i++) {
//		int max = Integer.MIN_VALUE;
//		for(int j = i; j < a.length; j++) {
//			if(a[j] > max) {
//				max = a[j];
//			}
//		}
//		if(k < res.length)
//			res[k++] = max;
//	}
//	for(int i : res)
//		System.out.print(i +" ");
//}
//this is done in class
	public static void main(String[] args) {
		int a[] = { 15, 21, 5, 8, 7, 2 };
		int res[] = new int[a.length - 1];
		for (int i = 0; i < a.length - 1; i++) {
			int max = a[i + 1];
			for (int j = i + 2; j < a.length; j++) {
				if (a[j] > max) {
					max = a[j];
				}
			}
			res[i] = max;
		}
		for (int i : res) {
			System.out.print(i + " ");
		}
	}
}
