package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MinSizeSubArraySumTest {

  private static final int[] inputA = {2, 1, 5, 2, 3, 2};
  private static final int inputASum = 0;
  private static final int outputA = 1;

  private static final int[] inputB = {2, 1, 5, 2, 8};
  private static final int inputBSum = 7;
  private static final int outputB = 1;

  private static final int[] inputC = {3, 4, 1, 1, 6};
  private static final int inputCSum = 8;
  private static final int outputC = 3;

  private static final int[] inputD = {3, 4, 1, 1, 6};
  private static final int inputDSum = -1;

  private static final int[] inputE = null;
  private static final int inputESum = 1;

  private static final int[] inputF = {50, 51, 52, 53, 54, 55, 56};
  private static final int inputFSum = 1000;
  private static final int outputF = 0;

  @Test
  @DisplayName("Min Size SubArray Success Cases.")
  void findMinSubArray_successful_minSizeSubarray() {
    assertEquals(outputA, MinSizeSubArraySum.findMinSubArray(inputASum, inputA));
    assertEquals(outputB, MinSizeSubArraySum.findMinSubArray(inputBSum, inputB));
    assertEquals(outputC, MinSizeSubArraySum.findMinSubArray(inputCSum, inputC));
  }

  @Test
  @DisplayName("Min Size SubArray Sum S not found.")
  void findMinSubArray_noMinSizeFound_returnZero() {
    assertEquals(outputF, MinSizeSubArraySum.findMinSubArray(inputFSum, inputF));
  }

  @Test
  @DisplayName("Min Size SubArray Sum S lesser than zero.")
  void findMinSubArray_sLesserThanZero_throwException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> MinSizeSubArraySum.findMinSubArray(inputDSum, inputD));
  }

  @Test
  @DisplayName("Min Size SubArray array is null.")
  void findMinSubArray_arrIsNull_throwException() {
    assertThrows(
        NullPointerException.class, () -> MinSizeSubArraySum.findMinSubArray(inputESum, inputE));
  }
}
