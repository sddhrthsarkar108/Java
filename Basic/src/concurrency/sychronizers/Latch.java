package concurrency.sychronizers;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Latch {
    public static void main(String[] args) {
        CountDownLatch cdl = new CountDownLatch(3);

        new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {

                }

                cdl.countDown();
            }
        }).start();

        try {
            // waiting for sequence of 3 events
            System.out.println("waiting in main thread");
            cdl.await();
        } catch (InterruptedException e) {

        }
    }
}
