package threading;

public class ThreadLocalTest {
    private ThreadLocal<String> myThreadLocal = ThreadLocal.withInitial(() -> "initial value");

    void useThreadLocal() {
        myThreadLocal.set("Hello ThreadLocal");
        myThreadLocal.get();
    }
}
