package com.iluwatar.serverless.baas.model;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * This class tests the Person.equals method
 */
public class PersonTest {

  @BeforeAll
  public static void setupCoverage() {
    Person.coverage = new boolean[9];
    Person.totalCoverage = new boolean[9];
  }

  /**
   * Print coverage and empty array
   */
  @AfterEach
  public void printAndCleanCoverage() {
    // Method did not run if default is false
    if (!Person.coverage[9]) {
      System.out.println("The method did not run");
      return;
    }
    System.out.print("[");
    for (int i = 0; i < Person.coverage.length; i++) {
      if (Person.coverage[i] || Person.totalCoverage[i]) {
        Person.totalCoverage[i] = true;
      }
      if (i < Person.coverage.length - 1) {
        System.out.print(Person.EQUALS_CONDS[i] + " is " + Person.coverage[i] + ", ");
      } else if (i == Person.coverage.length - 1) {
        System.out.print(Person.EQUALS_CONDS[i] + " is " + Person.coverage[i]);
      }
      Person.coverage[i] = false;
    }
    System.out.println("]");
    Arrays.fill(Person.coverage, false);
  }

  /**
   * Print the total coverage
   */
  @AfterAll
  public static void printCoverage() {
    System.out.println();
    System.out.println("Total coverage:");
    double coveredConds = 0;
    for (int i = 0; i < Person.totalCoverage.length - 1; i++) {
      if (Person.totalCoverage[i]) {
        System.out.println(Person.EQUALS_CONDS[i] + " has been covered");
        coveredConds++;
      } else {
        System.out.println(Person.EQUALS_CONDS[i] + " has not been covered");
      }
    }
    DecimalFormat df = new DecimalFormat("#.###");
    System.out.println("Covered " + df.format(coveredConds / Person.totalCoverage.length) + "% of all conditions");
  }
}
