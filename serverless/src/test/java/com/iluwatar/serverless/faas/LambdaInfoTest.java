package com.iluwatar.serverless.faas;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * Test class for LambdaInfo, currently only containing coverage tool
 *
 * Created by helenaalinder 2/15-19
 */
public class LambdaInfoTest {

  @BeforeAll
  public static void setupCoverage() {
    LambdaInfo.coverage = new boolean[37];
    LambdaInfo.totalCoverage = new boolean[37];
  }

  /**
   * Print coverage and empty array
   */
  @AfterEach
  public void printAndCleanCoverage() {
    // If default is false, method has not been run, don't print
    if (LambdaInfo.coverage[36] == false) {
      return;
    }

    System.out.print("[");
    for (int i = 0; i < LambdaInfo.coverage.length; i++) {
      if (LambdaInfo.coverage[i] || LambdaInfo.totalCoverage[i]) {
        LambdaInfo.totalCoverage[i] = true;
      }
      if (i < LambdaInfo.coverage.length - 1) {
        System.out.print(LambdaInfo.CONDS[i] + " is " + LambdaInfo.coverage[i] + ", ");
      } else if (i == LambdaInfo.coverage.length - 1) {
        System.out.print(LambdaInfo.CONDS[i] + " is " + LambdaInfo.coverage[i]);
      }
    }
    System.out.println("]");
    Arrays.fill(LambdaInfo.coverage, false);
  }

  /**
   * Print total coverage
   */
  @AfterAll
  public static void printCoverage() {
    System.out.println();
    System.out.println("Total coverage:");
    double coveredConds = 0;
    for (int i = 0; i < LambdaInfo.totalCoverage.length - 1; i++) {
      if (LambdaInfo.totalCoverage[i]) {
        System.out.println(LambdaInfo.CONDS[i] + " has been covered");
        coveredConds++;
      } else {
        System.out.println(LambdaInfo.CONDS[i] + " has not been covered");
      }
    }
    DecimalFormat df = new DecimalFormat("###.#");
    System.out.println("Covered "
        + df.format(((coveredConds + 1)
        / LambdaInfo.totalCoverage.length) * 100)
        + "% of all conditions");
    System.out.println();

  }

  @Test
  void dummy() {
    LambdaInfo i = new LambdaInfo();
    i.equals(i);
  }

}
