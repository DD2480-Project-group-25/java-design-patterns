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

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * 
 * Unit tests for {@link PlayerDetails}
 *
 */
class PlayerDetailsTest {
  @BeforeAll
  public static void beforeAll() {
    int branches = 13;
    PlayerDetails.visitedBranchGlobal = new boolean[branches];
    PlayerDetails.visitedBranchLocal = new boolean[branches];
  }

  @BeforeEach
  public void beforeEach() {
    Arrays.fill(PlayerDetails.visitedBranchLocal, false);
  }

  @AfterEach
  public void afterEach() {
    boolean verbose = false;

    for (int i = 0; i < PlayerDetails.visitedBranchLocal.length; i++) {
      if (PlayerDetails.visitedBranchLocal[i]) {
        PlayerDetails.visitedBranchGlobal[i] = true;
      }
    }
    if (verbose) {
      for (int i = 0; i < PlayerDetails.visitedBranchLocal.length; i++) {
        System.out.format("Branch %d covered: %b.\n", i, PlayerDetails.visitedBranchLocal[i]);
      }
    }
  }

  @AfterAll
  public static void afterAll() {
    int cover = 0;
    for (int i = 0; i < PlayerDetails.visitedBranchGlobal.length; i++) {
      System.out.format("Branch %d covered: %b.\n", i, PlayerDetails.visitedBranchGlobal[i]);
      if (PlayerDetails.visitedBranchGlobal[i]) {
        cover++;
      }
    }
    System.out.println("Test done, results:");
    System.out.format("Branch cover is: %f %%.\n", 100 * ((double) cover / PlayerDetails.visitedBranchGlobal.length));
  }

  @Test
  void testEquals() {
    PlayerDetails details1 = new PlayerDetails("tom@foo.bar", "11212-123434", "+12323425");
    PlayerDetails details2 = new PlayerDetails("tom@foo.bar", "11212-123434", "+12323425");
    assertEquals(details1, details2);
    PlayerDetails details3 = new PlayerDetails("john@foo.bar", "16412-123439", "+34323432");
    assertNotEquals(details1, details3);
  }  
}
