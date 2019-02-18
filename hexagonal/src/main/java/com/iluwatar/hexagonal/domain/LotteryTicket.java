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

/**
 * 
 * Immutable value object representing lottery ticket.
 *
 */
public class LotteryTicket {
  static boolean[] globalCoverage = new boolean[15];
  static boolean[] localCoverage = new boolean[15];

  private LotteryTicketId id;
  private final PlayerDetails playerDetails;
  private final LotteryNumbers lotteryNumbers;

  /**
   * Constructor.
   */
  public LotteryTicket(LotteryTicketId id, PlayerDetails details, LotteryNumbers numbers) {
    this.id = id;
    playerDetails = details;
    lotteryNumbers = numbers;
  }

  /**
   * @return player details
   */
  public PlayerDetails getPlayerDetails() {
    return playerDetails;
  }
  
  /**
   * @return lottery numbers
   */
  public LotteryNumbers getNumbers() {
    return lotteryNumbers;
  }

  /**
   * @return id
   */
  public LotteryTicketId getId() {
    return id;
  }

  /**
   * set id
   */
  public void setId(LotteryTicketId id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return playerDetails.toString() + " " + lotteryNumbers.toString();
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((lotteryNumbers == null) ? 0 : lotteryNumbers.hashCode());
    result = prime * result + ((playerDetails == null) ? 0 : playerDetails.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      localCoverage[0] = true;
      return true;
    }
    localCoverage[1] = true;
    if (obj == null) {
      localCoverage[2] = true;
      return false;
    }
    localCoverage[3] = true;
    if (getClass() != obj.getClass()) {
      localCoverage[4] = true;
      return false;
    }
    localCoverage[5] = true;
    LotteryTicket other = (LotteryTicket) obj;
    if (lotteryNumbers == null) {
      localCoverage[6] = true;
      if (other.lotteryNumbers != null) {
        localCoverage[7] = true;
        return false;
      }
      localCoverage[8] = true;
    } else if (!lotteryNumbers.equals(other.lotteryNumbers)) {
      localCoverage[9] = true;
      return false;
    }
    if (playerDetails == null) {
      localCoverage[10] = true;
      if (other.playerDetails != null) {
        localCoverage[11] = true;
        return false;
      }
      localCoverage[12] = true;
    } else if (!playerDetails.equals(other.playerDetails)) {
      localCoverage[13] = true;
      return false;
    }
    localCoverage[14] = true;
    return true;
  }
}
