package com.coding.pattern.slidingwindow;

import com.google.common.base.Preconditions;

public class MaxSubarrayOfSizeK {

  private MaxSubarrayOfSizeK() {}

  public static int findMaxSumSubArray0(int[] arr, int k) {
    Preconditions.checkArgument(k > 0, "Size K must greater than zero.");
    Preconditions.checkNotNull(arr, "Array must not be null.");

    int maxSum = 0;
    int windowSum;
    for (int i = 0; i <= arr.length - k; ++i) {
      windowSum = 0;
      for (int j = i; j < i + k; ++j) {
        windowSum += arr[j];
      }
      maxSum = Math.max(windowSum, maxSum);
    }

    return maxSum;
  }

  public static int findMaxSumSubArray1(int[] arr, int k) {
    Preconditions.checkArgument(k > 0, "Size K must greater than zero.");
    Preconditions.checkNotNull(arr, "Array must not be null.");

    int maxSum = 0;
    int windowSum = 0;
    int windowStart = 0;

    for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
      if (windowEnd >= k) {
        maxSum = Math.max(windowSum, maxSum);
        windowSum -= arr[windowStart];
        windowStart++;
      }
      windowSum += arr[windowEnd];
    }

    return maxSum;
  }
}
