package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;
import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement {
  private CharacterReplacement() {}

  public static int findLength(String str, int k) {
    Preconditions.checkNotNull(str);
    Preconditions.checkArgument(k > 0);

    int left = 0;
    int maxLength = 0;
    int maxCharOccurrence = 0;
    Map<Character, Integer> charMapFreq = new HashMap<>();

    for (int right = 0; right < str.length(); ++right) {
      char rightChar = str.charAt(right);
      charMapFreq.put(rightChar, charMapFreq.getOrDefault(rightChar, 0) + 1);

      maxCharOccurrence = Math.max(maxCharOccurrence, charMapFreq.get(rightChar));

      if (right - left + 1 - maxCharOccurrence > k) {
        char leftChar = str.charAt(left);
        charMapFreq.put(leftChar, charMapFreq.get(leftChar) - 1);
        left++;
      }
      maxLength = Math.max(maxLength, right - left + 1);
    }

    return maxLength;
  }
}
