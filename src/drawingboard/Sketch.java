package drawingboard;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.Supplier;

public class Sketch {

  public static void main(String[] args) {
    System.out.println("Start.......");
    try {

      ExampleSupplier supplier = new ExampleSupplier();
      CompletableFuture future = CompletableFuture.supplyAsync(supplier);
      System.out.println("future ->" + future.get());

      ExampleRunnable runnable = new ExampleRunnable();
      ExampleExecutor executor = new ExampleExecutor();
      CompletableFuture.runAsync(runnable, executor);

      CompletableFuture future3 = CompletableFuture.supplyAsync(() -> "complete");
      System.out.println("future3 ->" + future3.get());

      CompletableFuture future4 = CompletableFuture.runAsync(() -> System.out.println("inside runnable"), (s) -> s.run());
      System.out.println(future4.get());


    } catch (Exception ex) {
      ex.printStackTrace();
    }
    System.out.println("End.......");
  }
}

class ExampleSupplier implements Supplier {

  @Override
  public java.lang.String get() {
    return "complete";
  }

}

class ExampleRunnable implements Runnable {

  @Override
  public void run() {
    System.out.println("inside runnable");
  }
}

class ExampleExecutor implements Executor {

  @Override
  public void execute(Runnable command) {
    System.out.println("inside executor");
    command.run();
  }
}

