/**
 * 
 */
package tech.droptable.advent;

import java.lang.reflect.InvocationTargetException;

/**
 * 
 */
public class Main {

  public static void main(String[] args) {
    try {
      String name = args[0];
      Class clazz = Class.forName("tech.droptable.advent.impl." + name);
      Container container = (Container) clazz.getDeclaredConstructor().newInstance();
      Runner run = container.getRunner();
      run.setContainer(container);
      Thread t = new Thread(run);
      t.run();
      t.join();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
