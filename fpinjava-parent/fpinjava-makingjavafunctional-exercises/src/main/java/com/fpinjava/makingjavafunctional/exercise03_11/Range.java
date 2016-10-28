package com.fpinjava.makingjavafunctional.exercise03_11;

import com.fpinjava.common.CollectionUtilities;
import com.fpinjava.common.Function;

import java.util.ArrayList;
import java.util.List;


public class Range {

  public static List<Integer> range(int start, int end) {
    List<Integer> workList = new ArrayList<>();
    int temp = start;
    while (temp < end) {
      workList = CollectionUtilities.append(workList, temp);
      temp++;
    }
    return workList;
  }
}
