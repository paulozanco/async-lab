package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main_3 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> completableFuture
          = CompletableFuture.supplyAsync(() -> "Hello");

      CompletableFuture<Void> future = completableFuture
          .thenAccept(s -> System.out.println("Computation returned: " + s));

      future.get();

      System.out.println("End: Main");
    } catch (InterruptedException|ExecutionException ex) {
      ex.printStackTrace();
    }
  }
}

