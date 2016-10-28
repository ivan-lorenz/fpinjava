package com.fpinjava.makingjavafunctional.exercise03_14;

import com.fpinjava.common.CollectionUtilities;

import java.util.List;


public class Range {

  public static List<Integer> range(Integer start, Integer end) {
    return start < end ? CollectionUtilities.prepend(start, range(start + 1, end)) : CollectionUtilities.list();
  }
}
