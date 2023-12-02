/**
 * 
 */
package tech.droptable.advent.computer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import tech.droptable.advent.model.Model;

/**
 * 
 */
public interface Computer {

  CompletableFuture<Result> result(Model model);
}
