package lambdaexpression_14.dec_26;

public class FirstName02 {

	public static void main(String[] args) {
		First01 first = (name) -> {
			name = name.substring(0, name.indexOf(" "));
			System.out.println(name.substring(0, name.length() / 2));
		};
		first.printFirst("Pawan Kumar");
	}
}
