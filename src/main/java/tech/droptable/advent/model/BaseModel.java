/**
 * 
 */
package tech.droptable.advent.model;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 */
public class BaseModel<A> implements Model {
  
  Map<String,A> attributes;
  
  public BaseModel() {
    attributes = new HashMap<>();
  }
  
  public BaseModel(Map<String,A> att) {
    attributes = att;
  }

  @Override
  public Map<String, A> getAttributes() {
    return attributes;
  }
  
  public void put(String id, A attr) {
    attributes.put(id, attr);
  }

}
