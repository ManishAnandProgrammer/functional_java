package memoization;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class Memoizer<T, U> {

  private final Map<T, U> cache = new ConcurrentHashMap<>();

  private Memoizer() {}

  @org.jetbrains.annotations.NotNull
  @org.jetbrains.annotations.Contract(pure = true)
  private Function<T, U> doMemoize(final Function<T, U> function) {
    return input -> cache.computeIfAbsent(input, function::apply);
  }

  public static <T, U> Function<T, U> memoize(final Function<T, U> function) {
    return new Memoizer<T, U>().doMemoize(function);
  }
}