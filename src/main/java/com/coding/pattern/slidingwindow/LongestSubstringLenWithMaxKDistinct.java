package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringLenWithMaxKDistinct {

  private LongestSubstringLenWithMaxKDistinct() {}

  public static int findLength0(String str, int k) {
    Preconditions.checkArgument(str != null && !str.isBlank());
    Preconditions.checkArgument(k > 0);

    int maxLength = Integer.MIN_VALUE;
    int windowStart = 0;
    Map<Character, Integer> freqMap = new HashMap<>();

    for (int windowEnd = 0; windowEnd < str.length(); ++windowEnd) {
      char rightChar = str.charAt(windowEnd);

      freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);

      while (freqMap.size() > k) {
        char leftChar = str.charAt(windowStart);
        freqMap.put(leftChar, freqMap.get(leftChar) - 1);

        if (freqMap.get(leftChar) == 0) {
          freqMap.remove(leftChar);
        }
        windowStart++;
      }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }

  public static int findLength1(String str, int k) {
    Preconditions.checkArgument(str != null && !str.isBlank());
    Preconditions.checkArgument(k > 0);

    int maxLength = Integer.MIN_VALUE;
    int distinctChar = 0;
    int windowStart = 0;
    int[] freqMap = new int[128];

    for (int windowEnd = 0; windowEnd < str.length(); ++windowEnd) {
      if (freqMap[str.charAt(windowEnd)] == 0) {
        distinctChar++;
      }
      freqMap[str.charAt(windowEnd)]++;

      while (distinctChar > k) {
        freqMap[str.charAt(windowStart)]--;
        if (freqMap[str.charAt(windowStart)] == 0) {
          distinctChar--;
        }
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
}
