package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main_9 {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");

      String name = null;

      CompletableFuture<String> completableFuture = CompletableFuture
          .supplyAsync(
              () -> {
                if (name == null) {
                  throw new RuntimeException("Computation error!");
                }
                return "Hello, " + name;
              }
          ).handle((s, t) -> s != null ? s : "Exception [ "+t.getMessage()+"]");

      System.out.println("completableFuture = " + completableFuture.get());

      CompletableFuture<String> completableFutureException = new CompletableFuture();
      completableFutureException.completeExceptionally(new RuntimeException("Calculation failed!"));

      System.out.println("completableFutureException = " + completableFutureException.get());

      System.out.println("End: Main");
    } catch (Exception ex) {
      ex.printStackTrace();
    }
  }
}

