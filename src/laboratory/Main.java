package laboratory;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) {
    try {
      System.out.println("Start: Main");
      Future<String> future = Main.calculateAsync();
      String hello = future.get();
      System.out.println("Output = [" + hello + "]");
      System.out.println("End: Main");
    } catch (InterruptedException | ExecutionException ex) {
      ex.printStackTrace();
    }
  }

  public static Future<String> calculateAsync() throws InterruptedException {
    CompletableFuture<String> completableFuture
        = new CompletableFuture<>();

    ExecutorService service = Executors.newCachedThreadPool();

    service.submit(() -> {
      TimeUnit.SECONDS.sleep(5);
      completableFuture.complete("Hello");
      return null;
    });

    service.shutdown();

    return completableFuture;
  }


}
