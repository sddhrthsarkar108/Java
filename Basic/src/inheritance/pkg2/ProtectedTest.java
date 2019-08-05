package inheritance.pkg2;

import inheritance.pkg1.A;

class B extends A  {

}

public class ProtectedTest  {
    public static void main(String[] args) {
        B b = new B();
        // System.out.println(b.count); // protected member of interfaces.nesting.A bbecomes private in B
        System.out.println(b.countAlias);
    }
}
