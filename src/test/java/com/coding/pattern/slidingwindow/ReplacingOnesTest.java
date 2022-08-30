package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ReplacingOnesTest {

  private final int[] inputA = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
  private final int inputAk = 2;
  private final int outputA = 6;

  private final int[] inputB = {0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1};
  private final int inputBk = 3;
  private final int outputB = 9;

  private final int[] inputC = null;
  private final int inputCk = 1;

  private final int[] inputD = {1, 2, 3};
  private final int inputDk = -1;

  @Test
  @DisplayName("Success Case")
  void findLength_successCase_longestSubarray() {
    assertEquals(outputA, ReplacingOnes.findLength(inputA, inputAk));
    assertEquals(outputB, ReplacingOnes.findLength(inputB, inputBk));
  }

  @Test
  @DisplayName("Array is null.")
  void findLength_arrIsNull_throwException() {
    assertThrows(NullPointerException.class, () -> ReplacingOnes.findLength(inputC, inputCk));
  }

  @Test
  @DisplayName("K is less than or equal to -1")
  void findLength_inputKLessThanOrEqualMinusOne_throwException() {
    assertThrows(IllegalArgumentException.class, () -> ReplacingOnes.findLength(inputD, inputDk));
  }
}
