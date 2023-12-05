package tech.droptable.advent.model;

import java.util.HashMap;
import java.util.Map;

public class MultiMapModel<A, B> implements Model<A> {

  Map<String, Map<A, B>> multiMap;
  
  public MultiMapModel() {
    multiMap = new HashMap<>();
  }
  
  @Override
  public Map<String, A> getAttributes() {
    // TODO Auto-generated method stub
    return null;
  }
  
  public Map<A, B> getMap(String id) {
    return multiMap.get(id);
  }
  
  public void addMap(String id, Map<A, B> map) {
    multiMap.put(id, map);
  }

}
