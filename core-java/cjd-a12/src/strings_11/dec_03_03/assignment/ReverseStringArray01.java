package strings_11.dec_03_03.assignment;

public class ReverseStringArray01 {

	public static void main(String[] args) {
		String s = "This is a class";
		String s1[] = s.split(" ");
		String res = "";
		for (int i = 0; i < s1.length; i++) {
			res = s1[i] + " " + res;
		}
		System.out.println(res);

//        res = "";
//        String s2[] = s.split(" ");
//        for(String s5 : s2) {
//        	for(int i = s5.length()-1; i >= 0; i--) {
//        		res += s5.charAt(i); 
//            }
//        	res += " ";
//        }
//        System.out.println(res);

		res = "";
		String s2[] = s.split(" ");
		for (String i : s2) {
			for (int j = i.length() - 1; j >= 0; j--) {
				res += i.charAt(j);
			}
			res += " ";
		}
		System.out.println(res);

		String s3[] = s.split(" ");
		res = "";
		for (int i = 0; i < s3.length; i++) {
			if (res.length() < s3[i].length()) {
				res = s3[i];
			}
		}
		System.out.println("Max length word is : " + res);

		String str = "This is a class";
		String str1[] = str.split(" ");
		String max = "";
		for (String str2 : str1) {
			if (str2.length() > max.length()) {
				max = str2;
			}
		}
		System.out.println(max);

		String str2 = "This is a class";
		String str3[] = str2.split(" ");
		String result = "";
		for (String str4 : str3) {
			result += reverse(str4) + " ";
		}
		System.out.println(result);
	}

	public static String reverse(String s) {
		String rev = "";
		for (int i = 0; i < s.length(); i++) {
			rev = s.charAt(i) + rev;
		}
		return rev;
	}
}
