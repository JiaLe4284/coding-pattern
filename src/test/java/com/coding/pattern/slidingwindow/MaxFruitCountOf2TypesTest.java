package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxFruitCountOf2TypesTest {

  private final char[] inputA = {'A', 'B', 'C', 'A', 'C'};
  private final int outputA = 3;

  private final char[] inputB = {'A', 'B', 'C', 'B', 'B', 'C'};
  private final int outputB = 5; // TODO check bug outputB should be 3

  private final char[] inputC = null;

  @Test
  @DisplayName("Success Case")
  void findLength_successCase_maxFruitCount() {
    assertEquals(outputA, MaxFruitCountOf2Types.findLength(inputA));
    assertEquals(outputB, MaxFruitCountOf2Types.findLength(inputB));
  }

  @Test
  @DisplayName("Input Char Array is Null")
  void findLength_inputCharArrayIsNull_throwException() {
    assertThrows(NullPointerException.class, () -> MaxFruitCountOf2Types.findLength(inputC));
  }
}
