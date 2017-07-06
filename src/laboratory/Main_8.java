package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_8 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
      CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
      CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

      CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

      System.out.println("combinedFuture = " + combinedFuture.get());

      System.out.println("future1 = " + future1.isDone());
      System.out.println("future2 = " + future2.isDone());
      System.out.println("future3 = " + future3.isDone());

      String combined = Stream.of(future1, future2, future3)
          .map(CompletableFuture::join)
          .collect(Collectors.joining(" "));

      System.out.println("combined = " + combined);

      System.out.println("End: Main");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

