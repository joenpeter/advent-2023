/**
 * 
 */
package tech.droptable.advent.computer;

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

  protected abstract Result internalResult(Model model);

}
