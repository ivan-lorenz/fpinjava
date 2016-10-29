package com.fpinjava.recursion.exercise04_05;

import java.util.List;

import com.fpinjava.common.Function;
import static com.fpinjava.common.CollectionUtilities.*;

public class FoldRight {

  public static <T, U> U foldRight(List<T> ts, U identity, Function<T, Function<U, U>> f) {
    return foldRight_(identity, reverse(ts),identity,f);
  }

  private static <T,U> U foldRight_(U acc, List<T> ts, U identity, Function<T, Function<U,U>> f) {
    return ts.isEmpty()
            ? acc
            : foldRight_(f.apply(head(ts)).apply(acc), tail(ts), identity, f);

  }
}
