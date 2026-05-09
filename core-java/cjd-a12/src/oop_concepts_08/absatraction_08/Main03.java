package oop_concepts_08.absatraction_08;

public class Main03 {

	public static void main(String[] args) {
		ATM01 ob = new Bank02().atm();
		ob.withdraw();
		ob.balanceEnquiry();
	}
}
