package concurrency.future.cf;

import java.util.concurrent.CompletableFuture;

public class CFConsumer {
    public static void main(String[] args) {
        // thenAccept() example
        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
            return "done";
        }).thenAccept(product -> {
            System.out.println("Got product detail from remote service " + product);
        });

        // thenRun() example
        CompletableFuture.supplyAsync(() -> {
            return "";
        }).thenRun(() -> {
            // Computation Finished.
        });
    }
}
