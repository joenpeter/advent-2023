/**
 * 
 */
package tech.droptable.advent.computer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import tech.droptable.advent.model.Model;

/**
 * 
 */
public class ScratchCardPointsComputer extends AbstractComputer {

  @Override
  protected Result internalResult(Model m) {
    Model<Map<List<Integer>,List<Integer>>> model = (Model<Map<List<Integer>,List<Integer>>>)m;
    int result = 0;
    System.out.println(model.getAttributes().toString());
    for(Map<List<Integer>,List<Integer>> value: model.getAttributes().values()) {
      result = result + countPoints(value);
    }
    
    return new IntegerResult(result);
  }

  protected int countPoints(Map<List<Integer>, List<Integer>> map) {
    Entry<List<Integer>, List<Integer>> card = map.entrySet().iterator().next();
    List<Integer> first = card.getKey();
    List<Integer> last = card.getValue();
    int points = 0;
    
    for(Integer current: last) {
      if(first.contains(current)) {
//        System.out.print("" + current + ":" + "HIT ");
        if(points == 0) {
          points = 1;
        } else {
          points = points * 2;
        }
      } else {
//        System.out.print("" + current + ":" + "miss ");
      }
    }
//    System.out.println();
//    System.out.println("Total: " + points);
    
    return points;
  }

}
