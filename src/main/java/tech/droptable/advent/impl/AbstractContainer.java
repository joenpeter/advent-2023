/**
 * 
 */
package tech.droptable.advent.impl;

import tech.droptable.advent.Container;
import tech.droptable.advent.Runner;
import tech.droptable.advent.computer.Computer;
import tech.droptable.advent.loader.Loader;
import tech.droptable.advent.processor.Processor;

/**
 * 
 */
public abstract class AbstractContainer implements Container {

  @Override
  public final String getPath() {
    // TODO Auto-generated method stub
    return "src/main/resources/" + internalPath();
  }
  
  protected abstract String internalPath();

}
