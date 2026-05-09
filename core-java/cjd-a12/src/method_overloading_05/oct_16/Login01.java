package method_overloading_05.oct_16;

public class Login01 {

	public static void login(String email, String password){
		System.out.println("Email Login Successful");
	}
	public static void login(long mobile, String password){
		System.out.println("Mobile Login Successful");
	}
	public static void main(String[] args){
		login("abc@gmail.com","qwerty@123");
		login(987655677L,"qwerty@123");
	}
}
