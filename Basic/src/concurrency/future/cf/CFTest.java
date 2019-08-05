package concurrency.future.cf;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class CFTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<String>();

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                completableFuture.complete("manually completed");
            } catch (InterruptedException e) {
            }
        });
        t1.start();

        System.out.println(completableFuture.get());

        // Run a task specified by a Runnable Object asynchronously.
        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            // Simulate a long-running Job
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            System.out.println("I'll run in a separate thread than the main thread.");

        });

        // Block and wait for the future to complete
        future1.get();

        // Run a task specified by a Supplier object asynchronously
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Result of the asynchronous computation";
        });

        // Block and get the result of the Future
        String result = future2.get();
        System.out.println(result);
    }
}
