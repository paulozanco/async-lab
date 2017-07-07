package laboratory;

import java.util.concurrent.CompletableFuture;

public class Main_10 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> "Hello");

      CompletableFuture<String> future = completableFuture.thenApplyAsync(s -> s + " World");

      System.out.println("future.get() = " + future.get());

      System.out.println("End: Main");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

