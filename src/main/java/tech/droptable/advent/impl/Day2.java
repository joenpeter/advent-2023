package tech.droptable.advent.impl;

import java.util.Map;
import tech.droptable.advent.BasicRunner;
import tech.droptable.advent.Runner;
import tech.droptable.advent.computer.Computer;
import tech.droptable.advent.computer.SumOfPossibleGamesComputer;
import tech.droptable.advent.loader.LineByLineFileLoader;
import tech.droptable.advent.loader.Loader;
import tech.droptable.advent.model.CubeGameModel.Round;
import tech.droptable.advent.processor.CubeGameProcessor;
import tech.droptable.advent.processor.Processor;

public class Day2 extends AbstractContainer {

  @Override
  public Computer getComputer() {
    // TODO Auto-generated method stub
    Map<String, Integer> maxBatch = Map.of("red", 12, "green", 13, "blue", 14);
    return new SumOfPossibleGamesComputer(new Round(maxBatch));
  }

  @Override
  public Loader getLoader() {
    // TODO Auto-generated method stub
    return new LineByLineFileLoader();
  }

  @Override
  public Processor getProcessor() {
    // TODO Auto-generated method stub
    return new CubeGameProcessor();
  }

  @Override
  public Runner getRunner() {
    // TODO Auto-generated method stub
    return new BasicRunner();
  }

  @Override
  protected String internalPath() {
    // TODO Auto-generated method stub
    return "2";
  }

}
