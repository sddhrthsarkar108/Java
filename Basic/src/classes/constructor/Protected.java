package classes.constructor;

import classes.constructor.parent.Parent;

public class Protected {
    public Protected() {
        /**
         * Using super() Parent Class protected constructor can be called
         */
        super();
        System.out.println("Child Constructor called");
    }

    public static void main(String args[]) {
        /**
         * Even though we have extended Parent class in Child class,
         * below way of calling Parent class Constructor is not allowed
         *
         * The constructor Parent() is not visible - error will be thrown
         */
        // Parent p = new Parent(); // Error will be thrown
    }
}
