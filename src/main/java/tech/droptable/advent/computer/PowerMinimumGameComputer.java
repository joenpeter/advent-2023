package tech.droptable.advent.computer;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import tech.droptable.advent.model.CubeGameModel;
import tech.droptable.advent.model.CubeGameModel.CubeGame;
import tech.droptable.advent.model.CubeGameModel.Round;
import tech.droptable.advent.model.Model;

public class PowerMinimumGameComputer implements Computer {

  @Override
  public CompletableFuture<Result> result(Model model) {
    return CompletableFuture.supplyAsync(() -> {
      CubeGameModel gameModel = (CubeGameModel) model;
      int res = 0;
      for(CubeGame game: gameModel.getGames()) {
        Collection<Integer> minimums = findMinimums(game.getRounds());
        int gameTotals = 1;
        for(int a: minimums) {
          gameTotals = gameTotals * a;
        }
        res = res + gameTotals;
      }
      return new IntegerResult(res);
    });
  }

  private Collection<Integer> findMinimums(List<Round> rounds) {
    Map<String,Integer> minimums = new HashMap<>();
    for(Round round: rounds) {
      for(String colour: round.getCubes().keySet()) {
        if(!minimums.containsKey(colour)
            || (round.getCubes().get(colour) > minimums.get(colour))) {
          minimums.put(colour, round.getCubes().get(colour));
        }
      }
    }
    return minimums.values();
  }

}
