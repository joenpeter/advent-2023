/**
 * 
 */
package tech.droptable.advent.loader;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * 
 */
public class AbstractLoader implements Loader {

  @Override
  public CompletableFuture<Stream<String>> content(String path) {
    return CompletableFuture.supplyAsync(() -> internal(path));
  }

  private Stream<String> internal(String path) {
    // TODO Auto-generated method stub
    return null;
  }

}
