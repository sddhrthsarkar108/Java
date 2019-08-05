package threading.intrinsicLock;

class SomeClassObject {
    //changeValue locks on the class object's monitor
    public static synchronized void changeValue() {
        // ...
    }
}

class SomeClassObjectCompliant {
    private static final Object lock = new Object();

    public static void changeValue() {
        synchronized (lock) { // Locks on the private Object
            // ...
        }
    }
}

public class DOSClass {
    public static void main(String[] args) throws InterruptedException {
        synchronized (SomeClassObject.class) {
            while (true) {
                Thread.sleep(Integer.MAX_VALUE); // Indefinitely delay someObject
            }
        }


    }
}
