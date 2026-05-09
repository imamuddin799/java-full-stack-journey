package oop_concepts_08.relationship_04.has_a_relation_01.nov_08.assignment;

public class Writing03 {

	public static void main(String[] args) {
		Pen02 pen = new Pen02("Red", new Cap01("Blue"));
		pen.cap.openCap();
		pen.writes();
		pen.cap.closeCap();
	}
}
