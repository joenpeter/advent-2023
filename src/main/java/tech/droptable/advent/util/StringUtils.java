/**
 * 
 */
package tech.droptable.advent.util;

/**
 * 
 */
public class StringUtils {
  
  public static String findFirst(String data, String ...find) {
    String result = null;
    String search = data;
    while(result == null) {
      for(String s: find) {
        if(search.startsWith(s)) {
          result = s;
          break;
        }
      }
      search = search.substring(1);
    }
    return result;
  }
  
  public static String findLast(String data, String ...find) {
    String result = null;
    String search = data;
    while(result == null) {
      for(String s: find) {
        if(search.endsWith(s)) {
          result = s;
          break;
        }
      }
      search = search.substring(0, search.length()-1);
    }
    return result;    
  }

}
