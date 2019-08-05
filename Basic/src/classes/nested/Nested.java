package classes.nested;

public class Nested {

    static class StaticInnerClass {

    }

    class InnerClass {

    }

    public static void main(String[] args) {
        InnerClass ic = new Nested().new InnerClass();
        StaticInnerClass sic = new Nested.StaticInnerClass();
    }
}
