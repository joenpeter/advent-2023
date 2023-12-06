package tech.droptable.advent.processor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;
import tech.droptable.advent.model.MapModel;
import tech.droptable.advent.model.Model;

public class CharMapProcessor extends AbstractProcessor {

  @Override
  protected Model internalProcess(Stream<String> input) {
    List<char[]> rows = new ArrayList<>();
    Iterator<String> it = input.iterator();
    int i = 0;
    int len = 0;
    for(; it.hasNext(); i++) {
      String s = it.next();
      rows.add(s.toCharArray());
      if(s.length() > len) {
        len = s.length();
      }
    }
    Character[][] result = new Character[i][len];
    for(int n = 0; n < result.length; n++) {
      for(int t = 0; t < result[n].length; t++) {
        result[n][t] = rows.get(n)[t];
      }
    }
    return new MapModel<Character>(result);
  }

}
