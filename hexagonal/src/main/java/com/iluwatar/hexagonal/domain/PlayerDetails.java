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
 * Immutable value object containing lottery player details.
 *
 */
public class PlayerDetails {

  private final String emailAddress;
  private final String bankAccountNumber;
  private final String phoneNumber;
  public static boolean[] visitedBranchGlobal = new boolean[13];
  public static boolean[] visitedBranchLocal = new boolean[13];


  /**
   * Constructor.
   */
  public PlayerDetails(String email, String bankAccount, String phone) {
    emailAddress = email;
    bankAccountNumber = bankAccount;
    phoneNumber = phone;
  }

  /**
   * @return email
   */
  public String getEmail() {
    return emailAddress;
  }
  
  /**
   * @return bank account number
   */
  public String getBankAccount() {
    return bankAccountNumber;
  }
  
  /**
   * @return phone number
   */
  public String getPhoneNumber() {
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "PlayerDetails{" + "emailAddress='" + emailAddress + '\''
        + ", bankAccountNumber='" + bankAccountNumber + '\''
        + ", phoneNumber='" + phoneNumber + '\'' + '}';
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((bankAccountNumber == null) ? 0 : bankAccountNumber.hashCode());
    result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    // Branch1
    if (this == obj) {
      visitedBranchLocal[0] = true;
      return true;
    }
    // Branch2
    if (obj == null) {
      visitedBranchLocal[1] = true;
      return false;
    }
    // Branch3
    if (getClass() != obj.getClass()) {
      visitedBranchLocal[2] = true;
      return false;
    }
    // Branch4
    PlayerDetails other = (PlayerDetails) obj;
    if (bankAccountNumber == null) {
      visitedBranchLocal[3] = true;
      // Branch5
      if (other.bankAccountNumber != null) {
        visitedBranchLocal[4] = true;
        return false;
      }
      // Branch6
    } else if (!bankAccountNumber.equals(other.bankAccountNumber)) {
      visitedBranchLocal[5] = true;
      return false;
    }
    // Branch7
    if (emailAddress == null) {
      visitedBranchLocal[6] = true;
      // Branch8
      if (other.emailAddress != null) {
        visitedBranchLocal[7] = true;
        return false;
      }
      // Branch9
    } else if (!emailAddress.equals(other.emailAddress)) {
      visitedBranchLocal[8] = true;
      return false;
    }
    // Branch10
    if (phoneNumber == null) {
      visitedBranchLocal[9] = true;
      // Branch11
      if (other.phoneNumber != null) {
        visitedBranchLocal[10] = true;
        return false;
      }
      // Branch12
    } else if (!phoneNumber.equals(other.phoneNumber)) {
      visitedBranchLocal[11] = true;
      return false;
    }
    // Branch13
    visitedBranchLocal[12] = true;
    return true;
  }
}
