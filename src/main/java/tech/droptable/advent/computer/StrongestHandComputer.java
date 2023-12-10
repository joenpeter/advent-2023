package tech.droptable.advent.computer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import tech.droptable.advent.model.Hand;
import tech.droptable.advent.model.Model;

public class StrongestHandComputer extends AbstractComputer<Hand> {

  @Override
  protected Result internalResult(Model<Hand> model) {
    long result = 0;
    List<Hand> hands = new ArrayList<>(model.getAttributes().values());
    hands.sort(null);
    Iterator<Hand> it = hands.iterator();
    for(int i = 1; it.hasNext(); i++) {
      Hand hand = it.next();
      result = result + (hand.getBet() * i);
    }
    return new IntegerResult(result);
  }

}
