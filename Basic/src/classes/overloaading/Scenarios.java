package classes.overloaading;

public class Scenarios {

    void m1(String s) {
        System.out.println("string");
    }

    public int m1(Object o) {
        System.out.println("object");
        return 1;
    }

    public static void main(String[] args) {
        Scenarios s = new Scenarios();

        s.m1(null);
    }
}
