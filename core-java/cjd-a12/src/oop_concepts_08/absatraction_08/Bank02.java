package oop_concepts_08.absatraction_08;

public class Bank02 {

	private class BOB implements ATM01 { // inner class

		public void withdraw() {
			System.out.println("1000000 withdraw successful");
		}

		public void balanceEnquiry() {
			System.out.println("1000000000000");
		}
	}

	public ATM01 atm() { // helper method
		return new BOB();
	}
}
