package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main_4 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> completableFuture
          = CompletableFuture.supplyAsync(() -> "Hello");

      CompletableFuture<Void> future = completableFuture
          .thenRun(() -> System.out.println("Computation finished."));

      future.get();

      System.out.println("End: Main");
    } catch (InterruptedException|ExecutionException ex) {
      ex.printStackTrace();
    }
  }
}

