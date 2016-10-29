  package com.fpinjava.recursion.exercise04_07;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.foldLeft;
import static com.fpinjava.common.CollectionUtilities.foldRight;

  public class ComposeAll {

  public static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return t -> {
      T result = t;
      for (Function<T,T> f : list) {
        result = f.apply(result);
      }
      return result;
    };
  }
  public static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return t -> foldLeft(list, t, tf -> g -> g.apply(tf));
  }

  public static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return t -> foldRight(list, t, f -> f::apply);
  }
}
