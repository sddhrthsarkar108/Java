package concurrency.future.cf;

import java.util.concurrent.CompletableFuture;

public class CFComine {
    static  CompletableFuture<String> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return "user";
        });
    }

    static  CompletableFuture<Integer> getUserAge(String user) {
        return CompletableFuture.supplyAsync(() -> {
            return 29;
        });
    }

    public static void main(String[] args) {
        CompletableFuture<CompletableFuture<Integer>> result = getUsersDetail("user")
                .thenApply(user -> getUserAge(user));

        CompletableFuture<Integer> topLevelResult = getUsersDetail("user")
                .thenCompose(user -> getUserAge(user));

    }
}
