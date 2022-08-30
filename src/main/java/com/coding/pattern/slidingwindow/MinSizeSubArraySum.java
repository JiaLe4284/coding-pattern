package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;

public class MinSizeSubArraySum {

  private MinSizeSubArraySum() {}

  public static int findMinSubArray(int s, int[] arr) {
    Preconditions.checkArgument(s >= 0, "s cannot be lesser than zero.");
    Preconditions.checkNotNull(arr, "arr cannot be null.");

    int windowSum = 0;
    int windowStart = 0;
    int minSize = Integer.MAX_VALUE;

    for (int i = 0; i < arr.length; i++) {
      windowSum += arr[i];

      while (windowSum >= s) {
        if (windowStart > i) break;
        minSize = Math.min(i + 1 - windowStart, minSize);
        windowSum -= arr[windowStart];
        windowStart++;
      }
    }

    return minSize == Integer.MAX_VALUE ? 0 : minSize;
  }
}
