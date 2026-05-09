package arrays_10.searching_02;

public class FirstAndLastOccurrence03 {

	public static void main(String[] args) {
//		int a[] = {5,3,2,3,8,3,7,5,3,8};
//		int ele = 3;
//		int ind = -1;
//		int count = 0;
//		int first = -1;
//		for(int i = 0; i < a.length; i++) {
//			if(a[i] == ele) {
//				ind = i;
//				count++;
//				if(count == 1) {
//					first = i;
//				}
//			}
//		}
//		if(ind == -1 || count < 2) {
//			System.out.println(ele +" Not found");
//		}
//		else {
//			System.out.println(ele +" is first Found at "+ first +" and last at "+ ind +" index");
//		}

//		int a[] = {5,3,2,3,7,5,8,3,7};
//		int ele = 2;
//		int f = -1, l = -1;
//		for(int i = 0; i < a.length; i++) {
//			if(a[i] == ele) {
//				if(f == -1) {
//					f = i;
//				}
//				l = i;
//			}
//		}
//		if(f == -1) {
//			System.out.println(ele +" not found");
//		}
//		else {
//			System.out.println(f +", "+ l);
//		}

		int a[] = { 5, 3, 2, 3, 7, 5, 8, 3, 7 };
		int ele = 5;
		int f = -1, l = -1;
		for (int i = 0, j = a.length - 1; i < a.length; i++, j--) {
			if (f == -1)
				if (a[i] == ele)
					f = i;
			if (l == -1)
				if (a[j] == ele)
					l = j;
			if (f != -1 && l != -1)
				break;
		}
		if (f == -1) {
			System.out.println(ele + " not found");
		} else {
			System.out.println(f + ", " + l);
		}
	}
}
