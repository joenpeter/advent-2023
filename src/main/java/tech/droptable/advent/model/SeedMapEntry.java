/**
 * 
 */
package tech.droptable.advent.model;

/**
 * 
 */
public class SeedMapEntry {
  
  private long start;
  private long end;
  private long offset;
  
  public SeedMapEntry(long start, long end, long offset) {
    this.start = start;
    this.end = end;
    this.offset = offset;
  }

  public long getStart() {
    return start;
  }
  
  public long getEnd() {
    return end;
  }
  
  public long getOffset() {
    return offset;
  }
}
