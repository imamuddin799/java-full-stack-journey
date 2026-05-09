package oop_concepts_08.relationship_04.is_a_relation_02.nov_09.assignments;

public class Garden03 {

	public static void main(String[] args) {
        Rose02 rose = new Rose02();
        rose.name = "Rose";
        rose.color = "Red";
        rose.fragrance = "Sweet";
        rose.isBlooming = true;
        rose.thornSize = "Small";
        rose.bloomPeriod = 3;

        Rose02 r = new Rose02();
        r.name = "Rose";
        r.color = "Yellow";
        r.fragrance = "Strong";
        r.isBlooming = false;
        r.thornSize = "Medium";
        r.bloomPeriod = 2;

        rose.display();
        r.display();
        System.out.println();
        rose.grow();
        r.grow();
        System.out.println();
        rose.bloom();
        r.bloom();
        System.out.println();
        rose.wither();
        r.wither();
        System.out.println();
        rose.bloomPeriod();
        r.bloomPeriod();
        System.out.println();
        rose.watered();
        r.watered();
    }
}
