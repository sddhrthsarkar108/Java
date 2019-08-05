package concurrency.sychronizers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;
import java.util.stream.IntStream;

class CustomPhaser extends Phaser {
    int phases;

    CustomPhaser(int parties, int phases) {
        super(parties);
        this.phases = phases;
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        System.out.println("Phase " + phase + " completed.");
        if (phase == phases || registeredParties == 0) {
            return true;
        }

        return false;
    }
}

public class Phasers {
    public static void main(String[] args) {
        CustomPhaser phaser = new CustomPhaser(1, 3);
        ExecutorService es = Executors.newFixedThreadPool(2);

        IntStream.iterate(0, i -> i + 1).limit(3).forEach(n -> es.execute(() -> {
            phaser.register();

            while (!phaser.isTerminated()) {
                System.out.println("Thread: " + Thread.currentThread().getName() + ", Phase: " + phaser.getPhase());
                phaser.arriveAndAwaitAdvance();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }));

        while (!phaser.isTerminated()) {
            phaser.arriveAndAwaitAdvance();
        }

        System.out.println("phaser is terminated");
    }
}
