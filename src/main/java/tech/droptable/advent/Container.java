package tech.droptable.advent;

import tech.droptable.advent.computer.Computer;
import tech.droptable.advent.loader.Loader;
import tech.droptable.advent.processor.Processor;

public interface Container {

  String getPath();
  
  Computer getComputer();
    
  Loader getLoader();
  
  Processor getProcessor();
  
  Runner getRunner();
}
