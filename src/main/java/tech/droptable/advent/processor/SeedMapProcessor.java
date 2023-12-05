/**
 * 
 */
package tech.droptable.advent.processor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import tech.droptable.advent.model.BaseModel;
import tech.droptable.advent.model.Model;
import tech.droptable.advent.model.MultiMapModel;
import tech.droptable.advent.model.SeedMapEntry;

/**
 * 
 */
public class SeedMapProcessor extends AbstractProcessor {

  @Override
  protected Model internalProcess(Stream<String> input) {
    BaseModel<List<SeedMapEntry>> model = new BaseModel<List<SeedMapEntry>>();
    Iterator<String> lines = input.iterator();
    while(lines.hasNext()) {
      String line = lines.next();
      if(line.contains(":")) {
        String[] ss = line.split(": ");
        // "\\s+"
        if(ss[0].contains("seeds")) {
          model.put("seeds", seedMap(ss[1]));
          System.out.println("Processed all seeds.");
        } else if(ss[0].contains("seed-to-soil map")) {
          model.put("soil", buildMap(lines));
        } else if(ss[0].contains("soil-to-fertilizer map")) {
          model.put("fertilizer", buildMap(lines));
        } else if(ss[0].contains("fertilizer-to-water map")) {
          model.put("water", buildMap(lines));
        } else if(ss[0].contains("water-to-light map:")) {
          model.put("light", buildMap(lines));
        } else if(ss[0].contains("light-to-temperature map")) {
          model.put("temperature", buildMap(lines));
        } else if(ss[0].contains("temperature-to-humidity map")) {
          model.put("humidity", buildMap(lines));
        } else if(ss[0].contains("humidity-to-location map")) {
          model.put("location", buildMap(lines));
        }
      }
    }
    
    System.out.println("Full map processed.");
    return model;
  }

  private List<SeedMapEntry> buildMap(Iterator<String> lines) {
    List<SeedMapEntry> result = new ArrayList<>();
    while(lines.hasNext()) {
      String line = lines.next();
      if(line.isBlank()) {
        return result;
      }
      String[] ss = line.split("\\s+");
      long des = Long.parseLong(ss[0]);
      long src = Long.parseLong(ss[1]);
      long len = Long.parseLong(ss[2]);
      result.add(new SeedMapEntry(src, src+len, des-src));
    }
    return result;
  }

  private List<SeedMapEntry> seedMap(String string) {
    List<SeedMapEntry> result = new ArrayList<>();
    String[] ss = string.split("\\s+");
    for(int i = 0; i < ss.length; i++) {
      long start = Long.parseLong(ss[i]);
      i++;
      long offset = Long.parseLong(ss[i]);
      result.add(new SeedMapEntry(start, start+offset, 0));
    }
    return result;
  }

}
