package com.fpinjava.recursion.exercise04_01;

import java.math.BigInteger;
import java.util.Objects;

public class Fibonacci {
  
  public static BigInteger fib(int x) {
    return fib_(BigInteger.ONE, BigInteger.ZERO, BigInteger.valueOf(x));
  }

  private static BigInteger fib_(BigInteger acc1, BigInteger acc2, BigInteger x) {
    if (Objects.equals(x, BigInteger.ZERO))
      return BigInteger.ZERO;
    else if (Objects.equals(x, BigInteger.ONE))
      return acc1.add(acc2);
    else
      return fib_(acc2, acc1.add(acc2), x.subtract(BigInteger.ONE));
  }
}
