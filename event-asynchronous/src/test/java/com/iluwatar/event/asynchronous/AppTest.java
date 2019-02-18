/**
 * The MIT License Copyright (c) 2014-2016 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.iluwatar.event.asynchronous;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Test for App class
 */
public class AppTest {
  @BeforeAll
  public static void setupCoverage() {
    App.coverage = new boolean[14];
    App.totalCoverage = new boolean[14];
  }

  /**
   * Print coverage and empty array
   */
  @AfterEach
  public void printAndCleanCoverage() {
    // Method did not run if default is false
    if (!App.coverage[13]) {
      System.out.println("The method did not run");
      return;
    }
    System.out.print("[");
    for (int i = 0; i < App.coverage.length; i++) {
      if (App.coverage[i] || App.totalCoverage[i]) {
        App.totalCoverage[i] = true;
      }
      if (i < App.coverage.length - 1) {
        System.out.print(App.INTERACTIVEMODE_CONDS[i] + " is " + App.coverage[i] + ", ");
      } else if (i == App.coverage.length - 1) {
        System.out.print(App.INTERACTIVEMODE_CONDS[i] + " is " + App.coverage[i]);
      }
    }
    System.out.println("]");
    Arrays.fill(App.coverage, false);
  }

  /**
   * Print the total coverage
   */
  @AfterAll
  public static void printCoverage() {
    System.out.println();
    System.out.println("Total coverage:");
    double coveredConds = 0;
    for (int i = 0; i < App.totalCoverage.length - 1; i++) {
      if (App.totalCoverage[i]) {
        System.out.println(App.INTERACTIVEMODE_CONDS[i] + " has been covered");
        coveredConds++;
      } else {
        System.out.println(App.INTERACTIVEMODE_CONDS[i] + " has not been covered");
      }
    }
    DecimalFormat df = new DecimalFormat("#.###");
    System.out.println("Covered " + df.format(((coveredConds + 1) / App.totalCoverage.length) * 100)
        + "% of all conditions");
  }
  @Test
  public void test() throws IOException {
    String[] args = {};
    App.main(args);
  }
}
