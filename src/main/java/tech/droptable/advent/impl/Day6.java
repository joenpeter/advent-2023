/**
 * 
 */
package tech.droptable.advent.impl;

import tech.droptable.advent.BasicRunner;
import tech.droptable.advent.Runner;
import tech.droptable.advent.computer.Computer;
import tech.droptable.advent.computer.RaceWinComputer;
import tech.droptable.advent.computer.TrackSeedComputer;
import tech.droptable.advent.loader.LineByLineFileLoader;
import tech.droptable.advent.loader.Loader;
import tech.droptable.advent.processor.BoatRaceProcessor;
import tech.droptable.advent.processor.Processor;
import tech.droptable.advent.processor.SeedMapProcessor;

/**
 * 
 */
public class Day6 extends AbstractContainer {

  @Override
  public Computer getComputer() {
    // TODO Auto-generated method stub
    return new RaceWinComputer();
  }

  @Override
  public Loader getLoader() {
    // TODO Auto-generated method stub
    return new LineByLineFileLoader();
  }

  @Override
  public Processor getProcessor() {
    // TODO Auto-generated method stub
    return new BoatRaceProcessor();
  }

  @Override
  public Runner getRunner() {
    // TODO Auto-generated method stub
    return new BasicRunner();
  }

  @Override
  protected String internalPath() {
    // TODO Auto-generated method stub
    return "6";
  }
}
