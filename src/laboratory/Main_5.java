package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main_5 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> completableFuture
          = CompletableFuture.supplyAsync(() -> "Hello")
          .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

      System.out.println("completableFuture.get() = " + completableFuture.get());

      System.out.println("End: Main");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

