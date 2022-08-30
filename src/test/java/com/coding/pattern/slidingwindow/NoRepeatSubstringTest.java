package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NoRepeatSubstringTest {

  private String inputA = "aabccbb";
  private int outputA = 3;

  private String inputB = "abbbb";
  private int outputB = 2;

  private String inputC = "abcadcbefg";
  private int outputC = 7;

  private String inputD = null;

  @Test
  @DisplayName("Success Case")
  void findLength_successCase_maxNoRepeatSubstringLength() {
    assertEquals(outputA, NoRepeatSubstring.findLength(inputA));
    assertEquals(outputB, NoRepeatSubstring.findLength(inputB));
    assertEquals(outputC, NoRepeatSubstring.findLength(inputC));
  }

  @Test
  @DisplayName("String is null")
  void findLength_stringIsNull_throwException() {
    assertThrows(NullPointerException.class, () -> NoRepeatSubstring.findLength(inputD));
  }
}
