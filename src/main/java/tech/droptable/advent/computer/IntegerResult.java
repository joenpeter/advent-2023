/**
 * 
 */
package tech.droptable.advent.computer;

/**
 * 
 */
public class IntegerResult implements Result {

  int result;
  
  public IntegerResult(int result) {
    this.result = result;
  }
  
  @Override
  public String stringResult() {
    return "" + result;
  }

}
