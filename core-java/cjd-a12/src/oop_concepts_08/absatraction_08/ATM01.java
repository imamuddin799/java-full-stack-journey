package oop_concepts_08.absatraction_08;

public interface ATM01 {

//	default void withdraw() {//We can have method body in non static methods also if the access specifier is 'default'
//	System.out.println("This is a default access specifier method");
//}

	public void withdraw();

	public void balanceEnquiry();
}
