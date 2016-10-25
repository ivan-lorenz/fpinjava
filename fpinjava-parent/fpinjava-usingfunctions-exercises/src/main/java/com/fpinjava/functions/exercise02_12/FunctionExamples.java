package com.fpinjava.functions.exercise02_12;

public class FunctionExamples {

  /*
   * Note: The same implementation may be used for all four cases.
   */

  public static final Function<Integer, Integer> factorial0 =
          n -> n == 0 ? 1 : n * FunctionExamples.factorial0.apply(n-1);

  public static Function<Integer, Integer> factorial1;
  static {
    factorial1 = n -> n == 0 ? 1 : n * factorial1.apply(n-1);
  }

  public final Function<Integer, Integer> factorial2 =
          n -> n == 0 ? 1 : n * this.factorial2.apply(n-1);

  public Function<Integer, Integer> factorial3;
  {
    factorial3 = n -> n == 0 ? 1 : n * factorial3.apply(n-1);
  }
}
