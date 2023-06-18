package com.coding.pattern.slidingwindow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class MaxSubarrayOfSizeKTest {
  @ParameterizedTest(name = "{index} {0} with size of {1} have {2}")
  @MethodSource
  @DisplayName("Success Case")
  void findMaxSumSubArray_maxSum(int[] inputArray, int sizeK, int expected) {
    assertEquals(expected, MaxSubarrayOfSizeK.findMaxSumSubArray0(inputArray, sizeK));
    assertEquals(expected, MaxSubarrayOfSizeK.findMaxSumSubArray1(inputArray, sizeK));
  }

  public static Stream<Arguments> findMaxSumSubArray_maxSum() {
    return Stream.of(
        Arguments.of(new int[] {2, 1, 5, 1, 3, 2}, 3, 9),
        Arguments.of(new int[] {2, 3, 4, 1, 5}, 2, 7));
  }

  @ParameterizedTest
  @MethodSource
  @DisplayName("Test Exception Case.")
  void findMaxSumSubArray_exceptionCase(int[] inputArray, int sizeK, Class<Throwable> clazz) {
    assertThrows(clazz, () -> MaxSubarrayOfSizeK.findMaxSumSubArray0(inputArray, sizeK));
    assertThrows(clazz, () -> MaxSubarrayOfSizeK.findMaxSumSubArray1(inputArray, sizeK));
  }

  public static Stream<Arguments> findMaxSumSubArray_exceptionCase() {
    return Stream.of(
        Arguments.of(new int[] {2, 3, 4, 1, 5}, 0, IllegalArgumentException.class),
        Arguments.of(null, 1, NullPointerException.class));
  }
}
