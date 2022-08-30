package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;

public class ReplacingOnes {
  public static int findLength(int[] arr, int k) {
    Preconditions.checkNotNull(arr);
    Preconditions.checkArgument(k > -1);

    int windowStart = 0;
    int maxLength = 0;
    int maxZerosCount = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      if (arr[windowEnd] == 0) maxZerosCount++;

      if (maxZerosCount > k) {
        if (arr[windowStart] == 0) maxZerosCount--;
        windowStart++;
      }

      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
    }
    return maxLength;
  }
}
