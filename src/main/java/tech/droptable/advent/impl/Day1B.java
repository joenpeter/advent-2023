/**
 * 
 */
package tech.droptable.advent.impl;

import tech.droptable.advent.BasicRunner;
import tech.droptable.advent.Container;
import tech.droptable.advent.Runner;
import tech.droptable.advent.computer.Computer;
import tech.droptable.advent.computer.SumOfAllComputer;
import tech.droptable.advent.loader.LineByLineFileLoader;
import tech.droptable.advent.loader.Loader;
import tech.droptable.advent.processor.AdvancedFirstLastNumberProcessor;
import tech.droptable.advent.processor.FirstLastNumberProcessor;
import tech.droptable.advent.processor.Processor;

/**
 * 
 */
public class Day1B extends AbstractContainer implements Container {

  @Override
  public Computer getComputer() {
    return new SumOfAllComputer();
  }

  @Override
  public Loader getLoader() {
    // TODO Auto-generated method stub
    return new LineByLineFileLoader();
  }

  @Override
  public Processor getProcessor() {
    // TODO Auto-generated method stub
    return new AdvancedFirstLastNumberProcessor();
  }

  @Override
  public Runner getRunner() {
    // TODO Auto-generated method stub
    return new BasicRunner();
  }

  @Override
  protected String internalPath() {
    // TODO Auto-generated method stub
    return "1";
  }

}
