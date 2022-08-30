package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxSumSubArrayOfSizeKTest {

  private static final int[] inputA = {2, 1, 5, 1, 3, 2};
  private static final int inputASize = 3;
  private static final int outputA = 9;

  private static final int[] inputB = {2, 3, 4, 1, 5};
  private static final int inputBSize = 2;
  private static final int outputB = 7;

  private static final int[] inputC = {2, 3, 4, 1, 5};
  private static final int inputCSize = 0;

  private static final int[] inputD = null;
  private static final int inputDSize = 1;

  @Test
  @DisplayName("Test Successful Case")
  void findMaxSumSubArray_successful_maxSum() {
    assertEquals(outputA, MaxSumSubArrayOfSizeK.findMaxSumSubArray0(inputASize, inputA));
    assertEquals(outputB, MaxSumSubArrayOfSizeK.findMaxSumSubArray0(inputBSize, inputB));

    assertEquals(outputA, MaxSumSubArrayOfSizeK.findMaxSumSubArray1(inputASize, inputA));
    assertEquals(outputB, MaxSumSubArrayOfSizeK.findMaxSumSubArray1(inputBSize, inputB));
  }

  @Test
  @DisplayName("Test Size K Lesser Than or Equals Zero.")
  void findMaxSumSubArray_sizeKLessThanEqualZero_promptError() {
    assertThrows(
        IllegalArgumentException.class,
        () -> MaxSumSubArrayOfSizeK.findMaxSumSubArray0(inputCSize, inputC));
    assertThrows(
        IllegalArgumentException.class,
        () -> MaxSumSubArrayOfSizeK.findMaxSumSubArray1(inputCSize, inputC));
  }

  @Test
  @DisplayName("Test Array is Null.")
  void findMaxSumSubArray_arrIsNull_promptError() {
    assertThrows(
        NullPointerException.class,
        () -> MaxSumSubArrayOfSizeK.findMaxSumSubArray0(inputDSize, inputD));
    assertThrows(
        NullPointerException.class,
        () -> MaxSumSubArrayOfSizeK.findMaxSumSubArray1(inputDSize, inputD));
  }
}
