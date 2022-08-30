package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class NoRepeatSubstring {

  private NoRepeatSubstring() {}

  public static int findLength(String str) {
    Preconditions.checkNotNull(str);

    int windowStart = 0;
    int maxLength = 0;
    Map<Character, Integer> charMapPos = new HashMap<>();

    for (int windowEnd = 0; windowEnd < str.length(); ++windowEnd) {
      if (charMapPos.containsKey(str.charAt(windowEnd))) {
        // abcadcbefg
        // after get 'c' + 1 position, we get 'b' + 1 position again
        // which is wrong because 'b' + 1 position is < than current
        // 'c' + 1 position
        windowStart = Math.max(windowStart, charMapPos.get(str.charAt(windowEnd)) + 1);
      }

      charMapPos.put(str.charAt(windowEnd), windowEnd);

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }

    return maxLength;
  }
}
