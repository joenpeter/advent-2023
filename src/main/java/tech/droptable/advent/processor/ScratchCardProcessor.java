package tech.droptable.advent.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import tech.droptable.advent.model.BaseModel;
import tech.droptable.advent.model.Model;

public class ScratchCardProcessor extends AbstractProcessor {

  @Override
  protected Model<Map<List<Integer>,List<Integer>>> internalProcess(Stream<String> input) {
    Map<String, Map<List<Integer>,List<Integer>>> attributes = new HashMap<>();
    
    input.forEach(line -> {
      String[] ss = line.split(": ");
      attributes.put(sanitize(ss[0]), createCard(ss[1]));
    });
    return new BaseModel<Map<List<Integer>,List<Integer>>>(attributes);
  }

  private String sanitize(String string) {
    return string.replaceAll("\\s+", " ");
  }

  private Map<List<Integer>, List<Integer>> createCard(String string) {
    String[] ss = string.split(" \\| ");
    List<Integer> first = new ArrayList<>();
    List<Integer> last = new ArrayList<>();
    for(String s: ss[0].split(" ")) {
      if(s.isBlank()) {
        continue;
      }
      first.add(Integer.parseInt(s));
    }
    for(String s: ss[1].split(" ")) {
      if(s.isBlank()) {
        continue;
      }
      last.add(Integer.parseInt(s));
    }
    Map<List<Integer>, List<Integer>> map = new HashMap<>();
    map.put(first, last);
//    System.out.println(string + " == " + map.toString());
    return map;
  }

}
