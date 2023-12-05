/**
 * 
 */
package tech.droptable.advent.computer;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import tech.droptable.advent.model.Model;

/**
 * 
 */
public abstract class AbstractComputer<A> implements Computer {

  @Override
  public CompletableFuture<Result> result(Model model) {
    return CompletableFuture.supplyAsync(() -> internalResult(model));
  }

  protected abstract Result internalResult(Model<A> model);
  
  protected long pickSmallest(List<Long> result) {
    result.sort(null);
    System.out.println(result);
    return result.get(0);
  }

}
