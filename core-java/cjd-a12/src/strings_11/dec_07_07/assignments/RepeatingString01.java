package strings_11.dec_07_07.assignments;

public class RepeatingString01 {

	public static void main(String[] args) {
		String s1 = "Java"; // "Hello"; //"ab";
		String s2 = "Hi"; // "Java"; //"_";
		int count = 1; // 2; //3;
		String res = "";
		if (count != 0) {
			res += s1;
			for (int i = 1; i < count; i++) {
				res += s2 + s1;
			}
		}
		System.out.println(res); // HelloJavaHello //ab_ab_ab

	}
}
