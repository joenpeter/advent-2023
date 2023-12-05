package tech.droptable.advent.computer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import tech.droptable.advent.model.Model;

public class ScratchCardPointsComputerB extends ScratchCardPointsComputer {
  @Override
  protected Result internalResult(Model m) {
    Model<Map<List<Integer>,List<Integer>>> model = (Model<Map<List<Integer>,List<Integer>>>)m;
    int result = 0;
    System.out.println(model.getAttributes().toString());
    Map<String,Map<List<Integer>,List<Integer>>> attr = model.getAttributes();
    Map<Integer, Integer> map = new HashMap<>();
    for(int cardNo = 1; attr.containsKey("Card " + cardNo); cardNo++) {
      result = result + calculateScratchers(cardNo, attr, map);
      System.out.println("Card " + cardNo + ": Completed");
    }

    
    return new IntegerResult(result);
  }

  private int calculateScratchers(int cardNo, Map<String, Map<List<Integer>, List<Integer>>> attr, Map<Integer,Integer> map) {
    if(!attr.containsKey("Card " + cardNo)) {
      return 0;
    }
    if(map.containsKey(cardNo)) {
      return map.get(cardNo);
    } else {
      int hits = countHits(attr.get("Card " + cardNo));
      int result = 0;
      for(int i = cardNo + 1; hits > 0; hits--) {
        result = result + calculateScratchers(i, attr, map);
        i++;
      }
      // I'm also a scratcher
      result++;
      map.put(cardNo, result);
      return result;
    }
  }

  private int countHits(Map<List<Integer>, List<Integer>> map) {
    Entry<List<Integer>, List<Integer>> card = map.entrySet().iterator().next();
    List<Integer> first = card.getKey();
    List<Integer> last = card.getValue();
    int points = 0;
    
    for(Integer current: last) {
      if(first.contains(current)) {
        points++;
      }
    }
    return points;
  }
}
