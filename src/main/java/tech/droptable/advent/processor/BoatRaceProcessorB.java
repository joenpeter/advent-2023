package tech.droptable.advent.processor;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;
import org.javatuples.Pair;
import tech.droptable.advent.model.BaseModel;
import tech.droptable.advent.model.Model;

public class BoatRaceProcessorB extends AbstractProcessor {

  @Override
  protected Model<Pair<Long,Long>> internalProcess(Stream<String> input) {
    Map<String, Pair<Long, Long>> attr = new HashMap<>();
    Iterator<String> it = input.iterator();
    String[] ss = it.next().split(":");
    long time = Long.parseLong(stripSpaces(ss[1]));
    ss = it.next().split(":");
    long distance = Long.parseLong(stripSpaces(ss[1]));
    attr.put("1", new Pair<Long, Long>(time, distance));
    return new BaseModel<Pair<Long,Long>>(attr);
  }

}
