/**
 * 
 */
package tech.droptable.advent.processor;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import tech.droptable.advent.model.Model;

/**
 * 
 */
public abstract class AbstractProcessor implements Processor {

  @Override
  public CompletableFuture<Model> process(Stream<String> input) {
    return CompletableFuture.supplyAsync(() -> internalProcess(input));
  }
  
  protected abstract Model internalProcess(Stream<String> input);
  
  protected String stripSpaces(String string) {
    String[] ss = string.trim().split("\\s+");
    String result = "";
    for(String s: ss) {
      result = result + s;
    }
    return result;
  }

}
