/**
 * 
 */
package tech.droptable.advent.computer;

import java.util.ArrayList;
import java.util.List;
import tech.droptable.advent.model.Model;
import tech.droptable.advent.model.SeedMapEntry;

/**
 * 
 */
public class TrackSeedComputer extends AbstractComputer<List<SeedMapEntry>> {

  @Override
  protected Result internalResult(Model<List<SeedMapEntry>> model) {
    List<SeedMapEntry> result = model.getAttributes().get("seeds");
   
    //Convert, step by step
    result = convert(model.getAttributes().get("soil"), result);
    result = convert(model.getAttributes().get("fertilizer"), result);
    result = convert(model.getAttributes().get("water"), result);
    result = convert(model.getAttributes().get("light"), result);
    result = convert(model.getAttributes().get("temperature"), result);
    result = convert(model.getAttributes().get("humidity"), result);
    result = convert(model.getAttributes().get("location"), result);
    
    return new IntegerResult(pickSmallestEntry(result));
  }

  private long pickSmallestEntry(List<SeedMapEntry> input) {
    long result = -1;
    for(SeedMapEntry i: input) {
      if(result == -1) {
        result = i.getStart();
      } else if(result > i.getStart()) {
        result = i.getStart();
      }
    }
    return result;
  }

  private List<SeedMapEntry> convert(List<SeedMapEntry> mapping, List<SeedMapEntry> input) {
    List<SeedMapEntry> result = new ArrayList<>();
    for(SeedMapEntry current: input) {
      result.addAll(convertOne(mapping, current));
    }
    return result;
  }

  private List<SeedMapEntry> convertOne(List<SeedMapEntry> list, SeedMapEntry current) {
    List<SeedMapEntry> result = new ArrayList<>();
    for(SeedMapEntry entry: list) {
      // Cases:
      // Start and end are within
      // Only start (split)
      // Only end (split)
      // None, but all of entry is within current (split twice)
      // None at all
      
      if(isWithin(current.getStart(), entry) && isWithin(current.getEnd(), entry)) {
        // Entire is within
        result.add(new SeedMapEntry(current.getStart() + entry.getOffset(), current.getEnd() + entry.getOffset(), 0));
        return result;
      } else if (isWithin(current.getStart(), entry)) {
        // Only start within - split and recurse
        result.add(new SeedMapEntry(current.getStart() + entry.getOffset(), entry.getEnd() + entry.getOffset(), 0));
        result.addAll(convertOne(list, new SeedMapEntry(entry.getEnd()+1, current.getEnd(), 0)));
        return result;
      } else if(isWithin(current.getEnd(), entry)) {
        // Only end within - split and recurse
        result.add(new SeedMapEntry(entry.getStart() + entry.getOffset(), current.getEnd() + entry.getOffset(), 0));
        result.addAll(convertOne(list, new SeedMapEntry(current.getStart(), entry.getStart()-1, 0)));
        return result;
      } else if(isWithin(entry.getStart(), current)) {
        // If one is within, both must be at this point
        // (current(entry)current) -> (recurse)(result)(recurse)
        result.add(new SeedMapEntry(entry.getStart() + entry.getOffset(), entry.getEnd() + entry.getOffset(), 0));
        result.addAll(convertOne(list, new SeedMapEntry(current.getStart(), entry.getStart()-1, 0)));
        result.addAll(convertOne(list, new SeedMapEntry(entry.getEnd()+1, current.getEnd(), 0)));
        return result;
      }
    }
    result.add(current);
    return result;
  }

  private boolean isWithin(long input, SeedMapEntry entry) {
    return input <= entry.getEnd() && input >= entry.getStart();
  }
  
  

  
}
