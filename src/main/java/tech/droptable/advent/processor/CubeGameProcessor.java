/**
 * 
 */
package tech.droptable.advent.processor;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;
import tech.droptable.advent.model.CubeGameModel;
import tech.droptable.advent.model.CubeGameModel.CubeGame;
import tech.droptable.advent.model.CubeGameModel.Round;
import tech.droptable.advent.model.Model;

/**
 * Processes input as cube games
 */
public class CubeGameProcessor implements Processor {

  @Override
  public CompletableFuture<Model> process(Stream<String> input) {
    return CompletableFuture.supplyAsync(() -> {
      CubeGameModel model = new CubeGameModel();
      input.forEach(s -> {
        String[] ss = s.split(": ");
        CubeGame game = new CubeGame(ss[0]);
        String[] rounds = ss[1].split("; ");
        for (String r: rounds) {
          Round round = new Round();
          String[] batches = r.split(", ");
          for(String batch: batches) {
            // " 11 green"
            String[] sbatch = batch.split(" ");
            round.addCubes(sbatch[1], Integer.parseInt(sbatch[0]));
          }
          game.addRound(round);
        }
        model.addGame(game);
      });
      return model;
    });
  }

}
