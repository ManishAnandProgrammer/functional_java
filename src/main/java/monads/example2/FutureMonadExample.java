package monads.example2;

import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class FutureMonadExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        whenReturnTypeIsNotACompleteableFuture();
        whenReturnTypeIsACompleteableFuture();
        usingFlatOfCompletableFuture();
        usingFlatOfCompletableFutureChaining();
    }

    private static void whenReturnTypeIsNotACompleteableFuture() {
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.completedFuture("manish anand");

        CompletableFuture<String> toUpperCase = stringCompletableFuture.thenApply(String::toUpperCase);
        CompletableFuture<String> replaceSpaceWithDollar  =
                toUpperCase.thenApply(s -> s.replace(" ", "$"));
        replaceSpaceWithDollar.thenAccept(System.out::println);
    }

    /*
    * In CompletableFuture thenApply works as a map() function
    * */
    private static void whenReturnTypeIsACompleteableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.completedFuture("manish anand");

        CompletableFuture<CompletableFuture<String>> toUpperCase =
                stringCompletableFuture.thenApply(name -> toUpperCase(name));

        CompletableFuture<CompletableFuture<String>> spaceToDollar =
                toUpperCase.get().thenApply(name -> replaceSpaceWithDollar(name));

        spaceToDollar
                .thenAccept(stringCompletableFuture1 ->
                        stringCompletableFuture1.thenAccept(System.out::println));
    }

    /*
     * In CompletableFuture thenCompose works as a flatMap() function
     * */
    private static void usingFlatOfCompletableFuture() throws ExecutionException, InterruptedException {
        CompletableFuture<String> stringCompletableFuture =
                CompletableFuture.completedFuture("manish anand");

        CompletableFuture<String> toUpperCase =
                stringCompletableFuture.thenCompose(name -> toUpperCase(name));

        CompletableFuture<String> removeSpace =
        toUpperCase.thenCompose(name -> replaceSpaceWithDollar(name));
        removeSpace.thenAccept(System.out::println);
    }

    /*
     * In CompletableFuture thenCompose works as a flatMap() function
     * */
    private static void usingFlatOfCompletableFutureChaining() throws ExecutionException, InterruptedException {
        CompletableFuture.completedFuture("manish anand")
                .thenCompose(name -> toUpperCase(name))
                .thenCompose(name -> replaceSpaceWithDollar(name))
                .thenAccept(System.out::println);
    }

    private static CompletableFuture<String> toUpperCase(final String value) {
        return CompletableFuture.completedFuture(value.toUpperCase());
    }

    private static CompletableFuture<String> replaceSpaceWithDollar(final String value) {
        return CompletableFuture.completedFuture(value.replace(" ", "$"));
    }
}
