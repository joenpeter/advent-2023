package tech.droptable.advent.processor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.stream.Stream;
import tech.droptable.advent.model.Model;

public interface Processor {

  CompletableFuture<Model> process(Stream<String> input);
}
