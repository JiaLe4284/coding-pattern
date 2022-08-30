package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LongestSubstringLenWithMaxKDistinctTest {

  private final String inputA = "araaci";
  private final int inputALen = 2;
  private final int outputA = 4;

  private final String inputB = "araaci";
  private final int inputBLen = 1;
  private final int outputB = 2;

  private final String inputC = "cbbebi";
  private final int inputCLen = 3;
  private final int outputC = 5;

  private final String inputD = "cbbebi";
  private final int inputDLen = 10;
  private final int outputD = 6;

  private final String inputE = "cbbebi";
  private final int inputELen = 0;

  private final String inputF = null;
  private final int inputFLen = 1;

  private final String inputG = "";
  private final int inputGLen = 1;

  @Test
  @DisplayName("Success Case")
  void findLength_successCase_maxLength() {
    assertEquals(outputA, LongestSubstringLenWithMaxKDistinct.findLength0(inputA, inputALen));
    assertEquals(outputB, LongestSubstringLenWithMaxKDistinct.findLength0(inputB, inputBLen));
    assertEquals(outputC, LongestSubstringLenWithMaxKDistinct.findLength0(inputC, inputCLen));
    assertEquals(outputD, LongestSubstringLenWithMaxKDistinct.findLength0(inputD, inputDLen));

    assertEquals(outputA, LongestSubstringLenWithMaxKDistinct.findLength1(inputA, inputALen));
    assertEquals(outputB, LongestSubstringLenWithMaxKDistinct.findLength1(inputB, inputBLen));
    assertEquals(outputC, LongestSubstringLenWithMaxKDistinct.findLength1(inputC, inputCLen));
    assertEquals(outputD, LongestSubstringLenWithMaxKDistinct.findLength1(inputD, inputDLen));
  }

  @Test
  @DisplayName("K < 1")
  void findLength_kLesserThanOne_throwException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> LongestSubstringLenWithMaxKDistinct.findLength0(inputE, inputELen));
    assertThrows(
        IllegalArgumentException.class,
        () -> LongestSubstringLenWithMaxKDistinct.findLength1(inputE, inputELen));
  }

  @Test
  @DisplayName("Input String is null or blank")
  void findLength_inputStrIsNullOrBlank_throwException() {
    assertThrows(
        IllegalArgumentException.class,
        () -> LongestSubstringLenWithMaxKDistinct.findLength0(inputF, inputFLen));
    assertThrows(
        IllegalArgumentException.class,
        () -> LongestSubstringLenWithMaxKDistinct.findLength1(inputF, inputFLen));

    assertThrows(
        IllegalArgumentException.class,
        () -> LongestSubstringLenWithMaxKDistinct.findLength0(inputG, inputGLen));
    assertThrows(
        IllegalArgumentException.class,
        () -> LongestSubstringLenWithMaxKDistinct.findLength1(inputG, inputGLen));
  }
}
