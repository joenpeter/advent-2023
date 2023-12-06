/**
 * 
 */
package tech.droptable.advent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 
 */
public class MapModel<A> implements Model<A> {

  A[][] map;
  
  public MapModel(A[][] m) {
    map = m;
  }
  
  @Override
  public Map<String, A> getAttributes() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public A[][] getMap() {
    return map;
  }
  
  public static class MapModelBuilder<A> {

  }

}
