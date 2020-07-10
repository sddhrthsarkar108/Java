package closure;

public class CarryStateEx2 {
    public static Runnable create() {
        int value = 4;
        Runnable runnable = () -> System.out.println(value);

        System.out.println("exiting create");
        return runnable;
    }
    public static void main(String[] args) {
        Runnable runnable = create();

        System.out.println("In main");
        runnable.run();
    }
}
