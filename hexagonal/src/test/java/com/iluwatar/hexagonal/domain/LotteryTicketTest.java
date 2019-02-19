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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/*
 * Test requirements documentation
 * ===============================
 *
 * Different edge cases as null pointers, other classes, same instance
 * were not tested. Tests for this were added.
 */
/**
 * Test Lottery Tickets for equality
 */
class LotteryTicketTest {
  private static final int BRANCHES = 15;

  private static void printInformation(String context, boolean[] coverage) {
    int covered = 0;
    for (boolean branch : coverage) {
      covered += branch ? 1 : 0;
    }
    int total = coverage.length;

    double shareCovered = ((double) covered) / ((double) total) * 100;

    System.out.printf("%d/%d (%6.2f%%) branches covered [%s]\n", covered, total, shareCovered, context);
  }

  @BeforeAll
  static void beforeAll() {
    LotteryTicket.globalCoverage = new boolean[BRANCHES];
  }

  @BeforeEach
  void beforeEach() {
    LotteryTicket.localCoverage = new boolean[BRANCHES];
  }

  @AfterEach
  void afterEach(TestInfo info) {
    for (int i = 0; i < BRANCHES; i++) {
      LotteryTicket.globalCoverage[i] = LotteryTicket.globalCoverage[i] || LotteryTicket.localCoverage[i];
    }
    printInformation(info.getDisplayName(), LotteryTicket.localCoverage);
  }

  @AfterAll
  static void afterAll() {
    printInformation("All tests", LotteryTicket.globalCoverage);
  }

  @Test
  void testEquals() {
    PlayerDetails details1 = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryNumbers numbers1 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket1 = new LotteryTicket(new LotteryTicketId(), details1, numbers1);
    PlayerDetails details2 = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryNumbers numbers2 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket2 = new LotteryTicket(new LotteryTicketId(), details2, numbers2);
    assertEquals(ticket1, ticket2);
    PlayerDetails details3 = new PlayerDetails("elsa@foo.bar", "1223-121212", "+49332322");
    LotteryNumbers numbers3 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 8)));
    LotteryTicket ticket3 = new LotteryTicket(new LotteryTicketId(), details3, numbers3);
    assertNotEquals(ticket1, ticket3);
  }

  @Test
  void sameObject() {
    PlayerDetails details = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryNumbers numbers = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket = new LotteryTicket(new LotteryTicketId(), details, numbers);

    assertTrue(ticket.equals(ticket));
  }

  @Test
  void otherNull() {
    PlayerDetails details = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryNumbers numbers = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket = new LotteryTicket(new LotteryTicketId(), details, numbers);

    assertFalse(ticket.equals(null));
  }

  @Test
  void otherClass() {
    PlayerDetails details = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryNumbers numbers = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket = new LotteryTicket(new LotteryTicketId(), details, numbers);

    assertFalse(ticket.equals(""));
  }

  @Test
  void numbersNullOtherNumbersNotNull() {
    PlayerDetails details1 = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryTicket ticket1 = new LotteryTicket(new LotteryTicketId(), details1, null);

    PlayerDetails details2 = new PlayerDetails("elsa@foo.bar", "1223-121212", "+49332322");
    LotteryNumbers numbers = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket2 = new LotteryTicket(new LotteryTicketId(), details2, numbers);

    assertFalse(ticket1.equals(ticket2));
  }

  @Test
  void numbersNullOtherNumbersNull() {
    PlayerDetails details1 = new PlayerDetails("bob@foo.bar", "1212-121212", "+34332322");
    LotteryTicket ticket1 = new LotteryTicket(new LotteryTicketId(), details1, null);

    PlayerDetails details2 = new PlayerDetails("elsa@foo.bar", "1223-121212", "+49332322");
    LotteryTicket ticket2 = new LotteryTicket(new LotteryTicketId(), details2, null);

    assertFalse(ticket1.equals(ticket2));
  }

  @Test
  void playerNullOtherPlayerNotNull() {
    LotteryNumbers numbers1 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket1 = new LotteryTicket(new LotteryTicketId(), null, numbers1);

    PlayerDetails details2 = new PlayerDetails("elsa@foo.bar", "1223-121212", "+49332322");
    LotteryNumbers numbers2 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket2 = new LotteryTicket(new LotteryTicketId(), details2, numbers2);

    assertFalse(ticket1.equals(ticket2));
  }

  @Test
  void playerNullOtherPlayerNull() {
    LotteryNumbers numbers1 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket1 = new LotteryTicket(new LotteryTicketId(), null, numbers1);

    LotteryNumbers numbers2 = LotteryNumbers.create(new HashSet<>(Arrays.asList(1, 2, 3, 4)));
    LotteryTicket ticket2 = new LotteryTicket(new LotteryTicketId(), null, numbers2);

    assertTrue(ticket1.equals(ticket2));
  }
}
