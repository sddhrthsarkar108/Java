package threading;

public class ShutdownHook {
    public static void main(String[] args) {
        Runtime t = Runtime.getRuntime();
        t.addShutdownHook(new Thread(() -> System.out.println("shutdown")));
    }
}
