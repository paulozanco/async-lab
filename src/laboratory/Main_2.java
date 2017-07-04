package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main_2 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> completableFuture
          = CompletableFuture.supplyAsync(() -> "Hello")
          .thenApply(s -> s + " World");

      String hello = completableFuture.get();

      System.out.println("Output = [" + hello + "]");

      System.out.println("End: Main");
    } catch (InterruptedException | ExecutionException ex) {
      ex.printStackTrace();
    }
  }
}

