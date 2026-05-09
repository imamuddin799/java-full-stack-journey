package oop_concepts_08.super_05.super_call_01;

class A {
    int a;
    A(int a){
        this.a = a;
    }
}
class B extends A {
    int b;
    B(int a, int b){
        super(a);
        this.b = b;
    }
}
public class Main01 {
    public static void main(String[] args) {
        B ob = new B(10, 20);
        System.out.println(ob.a);
        System.out.println(ob.b);
    }
}