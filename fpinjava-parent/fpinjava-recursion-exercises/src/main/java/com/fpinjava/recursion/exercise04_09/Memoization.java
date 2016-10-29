package com.fpinjava.recursion.exercise04_09;

import com.fpinjava.common.TailCall;

import java.util.List;
import static com.fpinjava.common.CollectionUtilities.*;
import static com.fpinjava.common.TailCall.*;

public class Memoization {

  public static String fibo(int number) {
    return makeString(fibo_(list(0), 1, 1, number).eval(), ", ");
  }

  public static <T> String makeString(List<T> list, String separator) {
    if (list.isEmpty())
      return "";

    if (list.size() == 1)
      return head(list).toString();

    return foldLeft(tail(list), new StringBuilder(head(list).toString()),
            (StringBuilder sb) -> i -> sb.append(separator).append(i.toString()))
            .toString();
  }

  private static TailCall<List<Integer>> fibo_(List<Integer> result, int acc1, int acc2, int number) {
    return number == 0
            ? ret(result)
            : sus(() -> fibo_(append(result,acc1), acc2, acc1+acc2, number - 1));
  }
}
