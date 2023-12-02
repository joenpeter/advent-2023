/**
 * 
 */
package tech.droptable.advent.processor;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import tech.droptable.advent.model.Model;
import tech.droptable.advent.util.StringUtils;
import tech.droptable.advent.model.BaseModel;

/**
 * 
 */
public class FirstLastNumberProcessor implements Processor {
  
  private static final String[] find = {"1","2","3","4","5","6","7","8","9","0"};

  @Override
  public CompletableFuture<Model> process(Stream<String> input) {
    return CompletableFuture.supplyAsync(() -> {
      Map<String,String> model = new HashMap<>();
      for(String i: input.toList()) {
        String res;
        res = StringUtils.findFirst(i, find);
        res = res + StringUtils.findLast(i, find);
        model.put(i, res);
      }
      return new BaseModel(model);
    });
  }

}
