/**
 * 
 */
package tech.droptable.advent.loader;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * 
 */
public interface Loader {
  
  CompletableFuture<Stream<String>> content(String path);

}
