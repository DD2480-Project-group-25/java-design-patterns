package com.iluwatar.serverless.baas.model;

import org.junit.jupiter.api.*;

public class AddressTest {
  private static final int BRANCHES = 32;

  private static void printInformation(String context, boolean[] coverage) {
    int covered = 0;
    for(boolean branch : coverage) {
      covered += branch ? 1 : 0;
    }
    int total = coverage.length;

    double shareCovered = ((double) covered) / ((double) total) * 100;

    System.out.printf("%d/%d (%6.2f%%) branches covered [%s]\n", covered, total, shareCovered, context);
  }

  @BeforeAll
  static void beforeAll() {
    Address.globalBranches = new boolean[BRANCHES];
  }

  @BeforeEach
  void beforeEach() {
    Address.localBranches = new boolean[BRANCHES];
  }

  @AfterEach
  void afterEach(TestInfo info) {
    for (int i = 0; i < BRANCHES; i++) {
      Address.globalBranches[i] = Address.globalBranches[i] || Address.localBranches[i];
    }
    printInformation(info.getDisplayName(), Address.localBranches);
  }

  @AfterAll
  static void afterAll() {
    printInformation("All tests", Address.globalBranches);
  }

  @Test
  void dummy() {}
}
