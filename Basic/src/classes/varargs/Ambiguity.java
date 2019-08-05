package classes.varargs;

public class Ambiguity {
    void m1() {
        System.out.println("no arg m1");
    }

    void m1(int ... i) {
        System.out.println("vararg m1");
    }

    void m2(int ... i) {
        System.out.println("vararg m1");
    }

    void m2(boolean ... i) {
        System.out.println("vararg m1");
    }

    public static void main(String[] args) {
        new Ambiguity().m1();

        // ambiguous call
        // new Ambiguity().m2();
    }
}
