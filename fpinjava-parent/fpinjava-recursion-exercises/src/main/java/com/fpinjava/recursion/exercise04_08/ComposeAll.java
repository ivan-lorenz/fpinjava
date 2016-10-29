package com.fpinjava.recursion.exercise04_08;

import java.util.List;

import com.fpinjava.common.Function;

import static com.fpinjava.common.CollectionUtilities.*;

public class ComposeAll {

  static <T> Function<T, T> composeAllViaFoldLeft(List<Function<T, T>> list) {
    return t -> foldLeft(reverse(list), t, tf -> g -> g.apply(tf));
  }

  static <T> Function<T, T> composeAllViaFoldRight(List<Function<T, T>> list) {
    return t -> foldRight(list, t, f -> f::apply);
  }

  static <T> Function<T, T> andThenAllViaFoldLeft(List<Function<T, T>> list) {
    return t -> foldLeft(list, t, tf -> g -> g.apply(tf));
  }

  static <T> Function<T, T> andThenAllViaFoldRight(List<Function<T, T>> list) {
    return t -> foldRight(reverse(list), t, f -> f::apply);
  }
}
