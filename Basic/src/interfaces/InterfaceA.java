package interfaces;

public interface InterfaceA {
    public static final int NO = 0;
    int YES = 1;

    default void m1() {
        System.out.println("m1 of interface A");
    }
}

interface InterfaceB extends InterfaceA {
    default void m1() {
        System.out.println("m1 of interface B");
        InterfaceA.super.m1();
    }
}
