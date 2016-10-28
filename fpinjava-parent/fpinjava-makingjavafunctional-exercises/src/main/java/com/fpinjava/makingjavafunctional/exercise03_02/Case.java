package com.fpinjava.makingjavafunctional.exercise03_02;

import com.fpinjava.common.Tuple;
import com.fpinjava.makingjavafunctional.exercise03_01.Result;

public class Case<T> extends Tuple<Supplier<Boolean>, Supplier<Result<T>>>{ // Case class should extend Tuple

  private Case(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
    super(booleanSupplier,resultSupplier);
  }

  public static <T> Case<T> mcase(Supplier<Boolean> condition, Supplier<Result<T>> value) {
    return new Case<T>(condition, value);
  }

  public static <T> DefaultCase<T> mcase(Supplier<Result<T>> value) {
    return new DefaultCase<T>(() -> true, value);
  }

  private static class DefaultCase<T> extends Case<T> {

    private DefaultCase(Supplier<Boolean> booleanSupplier, Supplier<Result<T>> resultSupplier) {
      super(booleanSupplier, resultSupplier);
    }
  }

  @SafeVarargs
  public static <T> Result<T> match(DefaultCase<T> defaultCase, Case<T>... matchers) {
    for (Case<T> matcher : matchers) {
      if (matcher._1.get())
        return matcher._2.get();
    }
    return defaultCase._2.get();
  }
}
