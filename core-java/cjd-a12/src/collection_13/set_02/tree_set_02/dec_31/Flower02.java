package collection_13.set_02.tree_set_02.dec_31;

public class Flower02 implements Comparable<Flower02> {

	String name;
	String color;
	double cost;

	public Flower02(String name, String color, double cost) {
		this.name = name;
		this.color = color;
		this.cost = cost;
	}

	public String toString() {
		return "\nFlower [name=" + name + ", color=" + color + ", cost=" + cost + "]";
//		return name +","+ color +","+cost;
	}

	public String toTable() {
		return name + "," + color + "," + cost;
	}

	public int compareTo(Flower02 o) {
		return this.name.compareTo(o.name);
	}

}