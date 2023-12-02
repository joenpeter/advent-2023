/**
 * 
 */
package tech.droptable.advent;

import java.util.concurrent.ExecutionException;

/**
 * 
 */
public class BasicRunner implements Runner {
  
  Container container;

  @Override
  public void run() {
    try {
      String output = container.getLoader().content(container.getPath())
        .thenCompose(s -> container.getProcessor().process(s))
        .thenCompose(m -> container.getComputer().result(m))
        .get().stringResult();
      
      System.out.println(output);
    } catch (InterruptedException | ExecutionException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  @Override
  public void setContainer(Container container) {
    this.container = container;
  }

}
