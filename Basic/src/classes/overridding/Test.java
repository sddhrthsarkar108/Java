package classes.overridding;

class A {
    void get(Object o) {

    }
}

public class Test extends A {
    // @Override // Method does not override method from its superclass
    void get(Integer o) {

    }
}
