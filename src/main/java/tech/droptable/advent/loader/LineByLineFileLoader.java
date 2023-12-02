/**
 * 
 */
package tech.droptable.advent.loader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * 
 */
public class LineByLineFileLoader implements Loader {

  @Override
  public CompletableFuture<Stream<String>> content(String path) {
    return CompletableFuture.supplyAsync(() -> {
      try {
        return Files.lines(Path.of(path));
      } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
      }
    });
  }

}
