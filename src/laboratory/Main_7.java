package laboratory;

import java.util.concurrent.CompletableFuture;

public class Main_7 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
          .thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"),
              (s1, s2) -> System.out.println(s1 + s2));

      System.out.println("completableFuture.get() = " + future.get());

      System.out.println("End: Main");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

