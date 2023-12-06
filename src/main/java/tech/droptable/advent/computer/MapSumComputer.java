package tech.droptable.advent.computer;

import tech.droptable.advent.model.MapModel;
import tech.droptable.advent.model.Model;

public class MapSumComputer extends AbstractComputer<Character> {

  @Override
  protected Result internalResult(Model<Character> m) {
    MapModel<Character> model = (MapModel<Character>) m;
    Character[][] map = model.getMap();
    int result = 0;
    String currentNumber = "";
    boolean isNumber = false;
    boolean found = false;
    for(int i = 0; i < map.length; i++) {
      for(int n = 0; n < map[i].length; n++) {
        if(Character.isDigit(map[i][n]) && isNumber) {
          //continued number
          currentNumber = currentNumber + map[i][n];
          if(!found) {
            found = checkSymbols(map, i, n);
          }
        } else if(Character.isDigit(map[i][n])) {
          isNumber = true;
          currentNumber = "" + map[i][n];
          found = checkSymbols(map, i , n);
        } else {
          if(found) {
            result = result + Integer.parseInt(currentNumber);
          } if(!found && isNumber) {
            System.out.println("Not found: " + currentNumber);
          }
          // reset
          isNumber = false;
          found = false;
          currentNumber = "";
        }
      }
    }
    
    return new IntegerResult(result);
  }

  private boolean checkSymbols(Character[][] map, int row, int col) {
    for(int i = -1; i <= 1; i++) {
      for(int n = -1; n <= 1; n++) {
        if(!isOutside(map, row + i, col +n)) {
          if(!Character.isDigit(map[row+i][col+n]) && map[row+i][col+n] != '.') {
            return true;
          }
        }
      }
    }
    return false;
  }

  protected boolean isOutside(Character[][] map, int i, int j) {
    if((i < 0 || i >= map.length) || (j < 0 || j >= map[i].length)) {
      return true;
    } else {
      return false;
    }
  }


}
