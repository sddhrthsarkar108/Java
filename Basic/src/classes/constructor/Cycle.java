package classes.constructor;

public class Cycle {
    Cycle() {
        this("SDJ");
    }

    Cycle(String str) {
        // this(); // CE
    }

    /*  Here compilation fails because  constructor chaining  */
    /*  has failed in  reaching the  object class.  */
    public static void main(String args[]) {
        Cycle c = new Cycle();
    }
}
