package concurrency.sychronizers.semaphores;

import java.util.concurrent.Semaphore;

public class Semaphores {
    static int count;

    public static void main(String[] args) {
        Semaphore sem = new Semaphore(2);

        new Thread(() -> {
            try {
                Thread.sleep(2000);
                // second thread would wait until count decreases
                sem.acquire(2);
                count++;
                System.out.println("count after increment: " + count);
                sem.release(2);
            } catch (InterruptedException e) {

            }
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(3000);
                sem.acquire();
                count--;
                System.out.println("count after decrement: " + count);
                sem.release();
            } catch (InterruptedException e) {

            }
        }).start();

    }
}
