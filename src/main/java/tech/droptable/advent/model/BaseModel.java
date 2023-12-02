/**
 * 
 */
package tech.droptable.advent.model;

import java.util.Map;

/**
 * 
 */
public class BaseModel implements Model {
  
  Map<String,String> attributes;
  
  public BaseModel() {
    
  }
  
  public BaseModel(Map<String,String> att) {
    attributes = att;
  }

  @Override
  public Map<String, String> getAttributes() {
    return attributes;
  }

}
