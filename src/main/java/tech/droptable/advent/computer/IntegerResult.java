/**
 * 
 */
package tech.droptable.advent.computer;

/**
 * 
 */
public class IntegerResult implements Result {

  long result;
  
  public IntegerResult(long result) {
    this.result = result;
  }
  
  @Override
  public String stringResult() {
    return "" + result;
  }

}
