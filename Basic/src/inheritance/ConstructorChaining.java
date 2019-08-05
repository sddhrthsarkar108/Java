package inheritance;


class A {
    A(int i) {

    }
}

class B extends A {
    B() {
        // need to make explicit call since there s no default constructor
        super(1);
    }
}

public class ConstructorChaining {
}
