package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class MaxFruitCountOf2Types {

  private MaxFruitCountOf2Types() {}

  public static int findLength(char[] arr) {
    Preconditions.checkNotNull(arr);

    int windowStart = 0;
    int maxDistinctFruitCount = 2;
    int maxFruitCount = 0;

    Map<Character, Integer> charMapFreq = new HashMap<>();

    for (int windowEnd = 0; windowEnd < arr.length; ++windowEnd) {
      char rightChar = arr[windowEnd];
      charMapFreq.put(rightChar, charMapFreq.getOrDefault(rightChar, 0) + 1);

      while (charMapFreq.size() > maxDistinctFruitCount) {
        char leftChar = arr[windowStart];
        charMapFreq.put(leftChar, charMapFreq.get(leftChar) - 1);

        if (charMapFreq.get(leftChar) == 0) {
          charMapFreq.remove(leftChar);
        }

        windowStart++;
      }

      maxFruitCount = Math.max(maxFruitCount, windowEnd - windowStart + 1);
    }

    return maxFruitCount;
  }
}
