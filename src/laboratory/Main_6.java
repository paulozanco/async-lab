package laboratory;

import java.util.concurrent.CompletableFuture;

public class Main_6 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> completableFuture
          = CompletableFuture.supplyAsync(() -> "Hello")
          .thenCombine(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> s1 + s2);

      System.out.println("completableFuture.get() = " + completableFuture.get());

      System.out.println("End: Main");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

