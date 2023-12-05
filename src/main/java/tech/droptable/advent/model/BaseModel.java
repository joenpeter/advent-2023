/**
 * 
 */
package tech.droptable.advent.model;

import java.util.Map;

/**
 * 
 */
public class BaseModel<A> implements Model {
  
  Map<String,A> attributes;
  
  public BaseModel() {
    
  }
  
  public BaseModel(Map<String,A> att) {
    attributes = att;
  }

  @Override
  public Map<String, A> getAttributes() {
    return attributes;
  }

}
