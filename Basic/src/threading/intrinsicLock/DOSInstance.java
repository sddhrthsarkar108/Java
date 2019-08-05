package threading.intrinsicLock;

class SomeObject {
    // Locks on the object's monitor
    public synchronized void changeValue() {
    }

    static SomeObject lookup(String name) {
        return new SomeObject();
    }
}

class SomeObjectCompliant {
    private final Object lock = new Object(); // private final lock object

    public void changeValue() {
        synchronized (lock) { // Locks on the private Object
            // ...
        }
    }
}


public class DOSInstance {
    public static void main(String[] args) throws InterruptedException {
        String name = "";// ...
        SomeObject someObject = SomeObject.lookup(name);
        if (someObject == null) {
            // ... handle error
        }
        synchronized (someObject) {
            while (true) {
                // Indefinitely lock someObject
                Thread.sleep(Integer.MAX_VALUE);
            }
        }
    }
}
