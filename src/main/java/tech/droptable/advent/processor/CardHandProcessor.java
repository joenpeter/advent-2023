package tech.droptable.advent.processor;

import java.util.HashMap;
import java.util.stream.Stream;
import tech.droptable.advent.model.BaseModel;
import tech.droptable.advent.model.Hand;
import tech.droptable.advent.model.Model;

public class CardHandProcessor extends AbstractProcessor {

  @Override
  protected Model internalProcess(Stream<String> input) {
    HashMap<String,Hand> hands = new HashMap<>();
    input.forEach(line -> {
      String[] ss = line.split("\\s+");
      hands.put(line, new Hand(ss[0], Integer.parseInt(ss[1])));
    });
    
    return new BaseModel<Hand>(hands);
  }

}
