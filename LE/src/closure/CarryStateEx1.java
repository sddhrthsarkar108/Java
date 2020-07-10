package closure;

public class CarryStateEx1 {
    public static void call(Runnable runnable) {
        System.out.println("stack 2: in call...");
        runnable.run();
    }

    public static void main(String[] args) {
        int value = 4;
        System.out.println("stack 1: in main...");
        call(() -> System.out.println("stack 3: in run..." + value));
    }
}
