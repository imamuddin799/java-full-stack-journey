package oop_concepts_08.basic_oop_01.oct_29;

public class Save04 {

	public static void main(String[] args) {
		Contact03 c = new Contact03();
		c.name = "Raj";
		c.number = 9876543210l;
		c.email = "Raj@gmail.com";
		c.address = "Gutta";
		c.save();
		System.out.println("\n**********************************\n");
		Contact03 c1 = new Contact03();
		c1.name = "Rani";
		c1.number = 7896543210l;
		c1.email = "Rani@gmail.com";
		c1.address = "Hills";
		c1.save();
	}
}