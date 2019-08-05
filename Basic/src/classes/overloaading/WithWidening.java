package classes.overloaading;

public class WithWidening {

    void m1(int i) {
        System.out.println("int");
    }

    void m1(Integer i) {
        System.out.println("Integer");
    }

    void m1(long l) {
        System.out.println("long");
    }

    void m1(Object o) {
        System.out.println("object");
    }

    void m2(int i) {
        System.out.println("int");
    }

    void m2(Long l) {
        System.out.println("Long");
    }

    void m2(float i) {
        System.out.println("float");
    }

    public static void main(String[] args) {
        WithWidening wo = new WithWidening();
        // object version would be called since widening is preferred over boxing
        wo.m1(Long.valueOf(34));
        // float version would be called since widening is preferred over boxing
        wo.m2(20l);
    }
}
