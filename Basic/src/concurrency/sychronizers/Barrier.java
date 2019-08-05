package concurrency.sychronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, () -> System.out.println("Barrier reached"));

        // two or more thread will wait at predefined point
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    cb.await();
                } catch (BrokenBarrierException | InterruptedException e) {

                }
            }).start();
        }

        //cb.reset();

        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
                try {
                    cb.await();
                } catch (BrokenBarrierException | InterruptedException e) {

                }
            }).start();
        }
    }
}
