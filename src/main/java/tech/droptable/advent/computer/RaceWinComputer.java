package tech.droptable.advent.computer;

import java.util.Map.Entry;
import org.javatuples.Pair;
import tech.droptable.advent.model.Model;

public class RaceWinComputer extends AbstractComputer<Pair<Long,Long>> {

  @Override
  protected Result internalResult(Model<Pair<Long,Long>> model) {
    long result = 1;
    for(Entry<String, Pair<Long, Long>> entry: model.getAttributes().entrySet()) {
      result = result * calculateWins(entry.getValue());
    }
    return new IntegerResult(result);
  }

  private long calculateWins(Pair<Long, Long> value) {
    long goal = value.getValue1();
    long result = 0;
    for(long current = 0; current <= value.getValue0(); current++) {
      long distance = calculateDistance(current, value.getValue0());
      if(distance > goal) {
        result++;
      }
    }
    return result;
  }

  private long calculateDistance(long pressedTime, Long timeTotal) {
    long timeLeft = timeTotal - pressedTime;
    long speed = pressedTime;
    return speed * timeLeft;
  }


}
