package tech.droptable.advent.computer;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import tech.droptable.advent.model.CubeGameModel;
import tech.droptable.advent.model.CubeGameModel.CubeGame;
import tech.droptable.advent.model.CubeGameModel.Round;
import tech.droptable.advent.model.Model;

public class SumOfPossibleGamesComputer implements Computer {

  Round max;
  
  public SumOfPossibleGamesComputer(Round maxLimits) {
    max = maxLimits;
  }
  
  @Override
  public CompletableFuture<Result> result(Model model) {
    return CompletableFuture.supplyAsync(() -> {
      int res = 0;
      List<CubeGame> games = ((CubeGameModel) model).getGames();
      for(CubeGame game: games) {
        boolean possible = true;
        for(Round round: game.getRounds()) {
          if(!roundIsPossible(round)) {
            possible = false;
            break;
          }
        }
        if(possible) {
          // "Game 4"
          String[] gameName = game.getName().split(" ");
          res = res + Integer.parseInt(gameName[1]);
        }
      }
      return new IntegerResult(res);
    });
  }

  private boolean roundIsPossible(Round round) {
    Map<String, Integer> cubes = round.getCubes();
    for(String colour: cubes.keySet()) {
      if(cubes.get(colour) > max.getCubes().get(colour)) {
        return false;
      }
    }
    return true;
  }

}
