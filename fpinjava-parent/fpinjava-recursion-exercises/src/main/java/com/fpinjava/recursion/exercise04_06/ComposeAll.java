package com.fpinjava.recursion.exercise04_06;

import java.util.List;

import com.fpinjava.common.Function;
import static com.fpinjava.common.CollectionUtilities.*;

public class ComposeAll {

  static <T> Function<T, T> composeAll(List<Function<T, T>> list) {
    return foldRight(list, Function.identity(), f -> f::compose);
  }
}
