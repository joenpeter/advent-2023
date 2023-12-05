/**
 * 
 */
package tech.droptable.advent.computer;

import java.util.concurrent.CompletableFuture;
import tech.droptable.advent.model.Model;

/**
 * 
 */
public class SumOfAllComputer implements Computer {

  @Override
  public CompletableFuture<Result> result(Model model) {
    return CompletableFuture.supplyAsync(() -> {
      int total = 0;
      for(String v: ((Iterable<String>)model.getAttributes().values())) {
        total = total + Integer.parseInt(v);
      }
      return new IntegerResult(total);
    });
  }

}
