package threading.interrupt;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("task1");
                Thread.sleep(1000);
                System.out.println("task2");
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread interrupted..." + e);
            }
        });
        t1.start();

        try {
            t1.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled " + e);
        }
    }
}

