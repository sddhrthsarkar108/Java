package classes.statics;

public class Scenarios {

    private final String userName;

    Scenarios() {
        System.out.println("default constructor.");
    }

    {
        userName = "sid";
        System.out.println("from 1st instance block.");
    }

    {
        System.out.println("from 2st instance block.");
    }

    // static block would be executed before main gets called by java
    static {
        System.out.println("from static block");
        main(new String[] {"from static block"});
    }

    public static void main(String[] args) {
        System.out.println("main called with args " + args.length);
        new Scenarios();
        System.out.println();
    }

//    op:
//    from static block
//    main called with args 1
//    from 1st instance block.
//    from 2st instance block.
//    default constructor.
//
//    main called with args 0
//    from 1st instance block.
//    from 2st instance block.
//    default constructor.
}
