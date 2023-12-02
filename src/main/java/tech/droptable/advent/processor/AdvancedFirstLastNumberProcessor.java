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
public class AdvancedFirstLastNumberProcessor implements Processor {

  private static final String[] find = {"1","2","3","4","5","6","7","8","9","0","one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

  @Override
  public CompletableFuture<Model> process(Stream<String> input) {
    return CompletableFuture.supplyAsync(() -> {
      Map<String,String> model = new HashMap<>();
      for(String i: input.toList()) {
        String res;
        res = convertNumber(StringUtils.findFirst(i, find));
        res = res + convertNumber(StringUtils.findLast(i, find));
        model.put(i, res);
      }
      return new BaseModel(model);
    });
  }

  private String convertNumber(String number) {
    if(number.length() == 1) {
      return number;
    }
    switch(number) {
      case "one":
        return "1";
      case "two":
        return "2";
      case "three":
        return "3";
      case "four":
        return "4";
      case "five":
        return "5";
      case "six":
        return "6";
      case "seven":
        return "7";
      case "eight":
        return "8";
      case "nine":
        return "9";
      default:
        return number;
    }
  }
}
