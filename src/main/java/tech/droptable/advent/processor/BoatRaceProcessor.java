/**
 * 
 */
package tech.droptable.advent.processor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import org.javatuples.Pair;
import tech.droptable.advent.model.BaseModel;
import tech.droptable.advent.model.Model;

/**
 * 
 */
public class BoatRaceProcessor extends AbstractProcessor {

  @Override
  protected Model<Pair<Long,Long>> internalProcess(Stream<String> input) {
    Map<String,Pair<Long,Long>> attributes = new HashMap<>();
    Iterator<String> it = input.iterator();
    String line = it.next(); // Top line, ie times
    String[] ss = line.split("\\s+");
    for(int i = 1; i < ss.length; i++) {
      attributes.put("" + i, new Pair<Long, Long>(Long.parseLong(ss[i]), 0l));
    }
    
    line = it.next(); // Second line, ie distance
    ss = line.split("\\s+");
    for(int i = 1; i < ss.length; i++) {
      Pair<Long,Long> pair = attributes.get("" + i);
      attributes.put("" + i, new Pair<Long, Long>(pair.getValue0(), Long.parseLong(ss[i])));
    }
    return new BaseModel<Pair<Long,Long>>(attributes); 
  }

}
