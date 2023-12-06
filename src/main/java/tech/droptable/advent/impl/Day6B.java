package tech.droptable.advent.impl;

import tech.droptable.advent.processor.BoatRaceProcessor;
import tech.droptable.advent.processor.BoatRaceProcessorB;
import tech.droptable.advent.processor.Processor;

public class Day6B extends Day6 {

  @Override
  public Processor getProcessor() {
    // TODO Auto-generated method stub
    return new BoatRaceProcessorB();
  }
}
