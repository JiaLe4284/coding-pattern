package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CharacterReplacementTest {

  private String inputA = "aabccbb";
  private int inputAk = 2;
  private int outputA = 5;

  private String inputB = "abbcb";
  private int inputBk = 1;
  private int outputB = 4;

  private String inputC = "abccde";
  private int inputCk = 1;
  private int outputC = 3;

  private String inputD = null;
  private int inputDk = 1;

  private String inputE = "abc";
  private int inputEk = 0;

  @Test
  @DisplayName("Success Case")
  void findLength_successCase_maxSubstringLength() {
    assertEquals(outputA, CharacterReplacement.findLength(inputA, inputAk));
    assertEquals(outputB, CharacterReplacement.findLength(inputB, inputBk));
    assertEquals(outputC, CharacterReplacement.findLength(inputC, inputCk));
  }

  @Test
  @DisplayName("String is null.")
  void findLength_stringIsNull_throwException() {
    assertThrows(
        NullPointerException.class, () -> CharacterReplacement.findLength(inputD, inputDk));
  }

  @Test
  @DisplayName("k is lesser than or equal to zero.")
  void findLength_kLesserThanOrEqualToZero_throwException() {
    assertThrows(
        IllegalArgumentException.class, () -> CharacterReplacement.findLength(inputE, inputEk));
  }
}
