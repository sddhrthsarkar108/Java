package classes.overloaading;

public class WithAutoboxing {

    void m1(int i) {
        System.out.println("int");
    }

    void m1(Integer i) {
        System.out.println("Integer");
    }

    void m1(long l) {
        System.out.println("long");
    }

    public static void main(String[] args) {
        WithAutoboxing wo = new WithAutoboxing();

        wo.m1(Long.valueOf(34));
    }
}
