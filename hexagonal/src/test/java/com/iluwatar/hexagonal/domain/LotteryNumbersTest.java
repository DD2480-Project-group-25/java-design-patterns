/**
 * The MIT License
 * Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.hexagonal.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

/**
 * 
 * Unit tests for {@link LotteryNumbers}
 *
 * Test class containing tests to increase the coverage
 * of LotteryNumbers.equals method.
 *
 * Previously tested requirements of LotteryNumbers.equals() (Coverage 50%) :
 * -Compares two LotteryNumbers (both positive and negative tests)
 *
 * Previously untested but now tested requirements of LotteryNumbers.equals() (Coverage 75%):
 * - Compares identity
 * - If the input object is Null
 * - If the input object is not of class LotteryNumbers
 *
 * It is not possible to get 100% coverage for LotteryNumbers.equals because there are 3 branches
 * that can only be covered when LotteryNumbers.numbers = null, however there is no way of creating
 * a LotteryNumbers with numbers = null inside the test class
 * since LotteryNumbers has private constructors and numbers is a private set.
 */
class LotteryNumbersTest {
  
  @Test
  void testGivenNumbers() {
    LotteryNumbers numbers = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertEquals(numbers.getNumbers().size(), 4);
    assertTrue(numbers.getNumbers().contains(1));
    assertTrue(numbers.getNumbers().contains(2));
    assertTrue(numbers.getNumbers().contains(3));
    assertTrue(numbers.getNumbers().contains(4));
  }
  
  @Test
  void testNumbersCantBeModified() {
    LotteryNumbers numbers = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertThrows(UnsupportedOperationException.class, () -> numbers.getNumbers().add(5));
  }
  
  @Test
  void testRandomNumbers() {
    LotteryNumbers numbers = LotteryNumbers.createRandom();
    assertEquals(numbers.getNumbers().size(), LotteryNumbers.NUM_NUMBERS);
  }
  
  @Test
  void testEquals() {
    LotteryNumbers numbers1 = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryNumbers numbers2 = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertEquals(numbers1, numbers2);
    LotteryNumbers numbers3 = LotteryNumbers.create(
            new HashSet<>(Arrays.asList(11, 12, 13, 14)));
    assertNotEquals(numbers1, numbers3);
  }

  /**
   * Test that equals() returns true when comparing the same object.
   */
  @Test
  public void testEqualsSameObject() {
    LotteryNumbers n =  LotteryNumbers.create(
        new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertTrue(n.equals(n));
  }
  /**
   * Test equals() where the input object is not of class LotteryNumbers.
   */
  @Test
  public void testDifferentClass() {
    LotteryNumbers n1 = LotteryNumbers.create(
        new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    String n2 = "H";
    assertFalse(n1.equals(n2));
  }

  /**
   * Test equals() with a null object as input.
   */
  @Test
  public void testEqualsNullObject() {
    LotteryNumbers n1 = LotteryNumbers.createRandom();
    LotteryNumbers n2 = null;
    assertFalse(n1.equals(n2));
  }

  /**
   * Test equals() two LotteryNumbers have different numbers.
   */
  @Test
  public void testDifferentNumbers() {
    LotteryNumbers n1 = LotteryNumbers.create(
        new HashSet<>(Arrays.asList(2, 2, 2, 2)));
    LotteryNumbers n2 = LotteryNumbers.create(
        new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    assertFalse(n1.equals(n2));
  }
  /**
   * Test equals() two LotteryNumbers have the same numbers.
   */
  @Test
  public void testSameNumbers() {
    LotteryNumbers n1 = LotteryNumbers.create(
        new HashSet<>(Arrays.asList(2, 2, 2, 2)));
    LotteryNumbers n2 = LotteryNumbers.create(
        new HashSet<>(Arrays.asList(2, 2, 2, 2)));
    assertTrue(n1.equals(n2));
  }
}
