package oop_concepts_08.encapsulation_03.nav_06;

public class WallClock04 {

	public static void main(String[] args) {
		Clock03 c1 = new Clock03();
		c1.setSecs(28);
		c1.setMins(20);
		c1.setHrs(7);
		c1.time();
		System.out.println(c1.getHrs() + ":" + c1.getMins());
		Clock03 c2 = new Clock03(45, 23, 7);
		c2.time();
	}
}
