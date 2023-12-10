package tech.droptable.advent.impl;

import tech.droptable.advent.BasicRunner;
import tech.droptable.advent.Runner;
import tech.droptable.advent.computer.Computer;
import tech.droptable.advent.computer.StrongestHandComputer;
import tech.droptable.advent.loader.LineByLineFileLoader;
import tech.droptable.advent.loader.Loader;
import tech.droptable.advent.processor.CardHandProcessor;
import tech.droptable.advent.processor.Processor;

public class Day7 extends AbstractContainer {

  @Override
  public Computer getComputer() {
    // TODO Auto-generated method stub
    return new StrongestHandComputer();
  }

  @Override
  public Loader getLoader() {
    // TODO Auto-generated method stub
    return new LineByLineFileLoader();
  }

  @Override
  public Processor getProcessor() {
    // TODO Auto-generated method stub
    return new CardHandProcessor();
  }

  @Override
  public Runner getRunner() {
    // TODO Auto-generated method stub
    return new BasicRunner();
  }

  @Override
  protected String internalPath() {
    // TODO Auto-generated method stub
    return "7-test";
  }

}
