package smsystem;

public class Sum60 {
	
	public static void sum60(int a[]) {
		boolean isFound = false;
		for(int i = 0; i < a.length-2; i++) {
			for(int j = i+1; j < a.length; j++) {
				for(int k = j+1; k < a.length; k++) {
					int sum = a[i] + a[j] + a[k];
					if(sum == 60) {
						System.out.println(a[i] +" "+ a[j] +" "+ a[k]);
						isFound = true;
					}
				}
			}
		}
		if(!isFound) {
			System.out.println("not found");
		}
	}

	public static void main(String[] args) {
		int a[] = {2, 6, 10, 18, 14, 22, 26, 30, 34, 38, 42, 46, 50, 53, 20};
		sum60(a);
	}
}