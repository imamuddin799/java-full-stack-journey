package strings_11.dec_06_06.assignments;

public class File03 {

	public static boolean digit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public static void main(String[] args) {
//		String s = "File_28, File_12, File_57, File_30";
//		String res = "";
//		String[] s1 = s.split(", ");
//		int num = 0;
//		for(String s2 : s1) {
//			int sum = 0;
//			for(int i = 0; i < s2.length(); i++) {
//				char ch = s2.charAt(i);
//				if(digit(ch)) {
//					int n = (int) ch - '0';
//					sum = sum * 10 + n;
//					if(sum > num) {
//						num = sum;
//						res = s2;
//					}
//				}
//			}
//		}
//		System.out.println(res);

		String s = "File_28, File_12, File_57, File_30";
		String res = "";
		String tres = "";
		int num = 0;
		int num1 = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ',') {
				tres += s.charAt(i);
				char ch = s.charAt(i);
				if (digit(ch)) {
					int n = (int) ch - '0';
					num1 = num1 * 10 + n;
					if (num1 > num) {
						num = num1;
						res = tres;
					}
				}
			} else {
				tres = "";
				num1 = 0;
				i++;
			}
		}
		System.out.println(res);
	}
}
