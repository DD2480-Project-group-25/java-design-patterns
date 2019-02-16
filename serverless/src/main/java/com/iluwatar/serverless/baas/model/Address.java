/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
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
package com.iluwatar.serverless.baas.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;

/**
 * Address class
 * Created by dheeraj.mummarareddy on 3/4/18.
 */
@DynamoDBDocument
public class Address implements Serializable {
  static boolean[] globalBranches;
  static boolean[] localBranches;

  private static final long serialVersionUID = 6760844284799736970L;

  private String addressLineOne;
  private String addressLineTwo;
  private String city;
  private String state;
  private String zipCode;

  @DynamoDBAttribute(attributeName = "addressLineOne")
  public String getAddressLineOne() {
    return addressLineOne;
  }

  public void setAddressLineOne(String addressLineOne) {
    this.addressLineOne = addressLineOne;
  }

  @DynamoDBAttribute(attributeName = "addressLineTwo")
  public String getAddressLineTwo() {
    return addressLineTwo;
  }

  public void setAddressLineTwo(String addressLineTwo) {
    this.addressLineTwo = addressLineTwo;
  }

  @DynamoDBAttribute(attributeName = "city")
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @DynamoDBAttribute(attributeName = "state")
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @DynamoDBAttribute(attributeName = "zipCode")
  public String getZipCode() {
    return zipCode;
  }

  public void setZipCode(String zipCode) {
    this.zipCode = zipCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      localBranches[0] = true;
      return true;
    }
    localBranches[1] = true;

    if (o == null || getClass() != o.getClass()) {
      if (o == null && getClass() != o.getClass()) {
        localBranches[2] = true; //Can never happen
      } else if(o == null) {
        localBranches[3] = true;
      } else if (getClass() != o.getClass()) {
        localBranches[4] = true;
      }
      return false;
    }
    localBranches[5] = true;

    Address address = (Address) o;

    //Expanded ternary
    if (addressLineOne != null) {
      localBranches[6] = true;
      if (!addressLineOne.equals(address.addressLineOne)) {
        localBranches[7] = true;
        return false;
      }
      localBranches[8] = true;
    } else {
      localBranches[9] = true;
      if (address.addressLineOne != null) {
        localBranches[10] = true;
        return false;
      }
      localBranches[11] = true;
    }

    //Expanded ternary
    if (addressLineTwo != null) {
      localBranches[12] = true;
      if (!addressLineTwo.equals(address.addressLineTwo)) {
        localBranches[13] = true;
        return false;
      }
      localBranches[14] = true;
    } else {
      localBranches[15] = true;
      if (address.addressLineTwo != null) {
        localBranches[16] = true;
        return false;
      }
      localBranches[17] = true;
    }

    if (city != null) {
      localBranches[18] = true;
      if (!city.equals(address.city)) {
        localBranches[19] = true;
        return false;
      } else {
        localBranches[20] = true;
      }
    } else {
      localBranches[21] = true;
      if (address.city != null) {
        localBranches[22] = true;
        return false;
      } else {
        localBranches[23] = true;
      }
    }

    if (state != null) {
      localBranches[24] = true;
      if (!state.equals(address.state)) {
        localBranches[25] = true;
        return false;
      } else {
        localBranches[26] = true;
      }
    } else {
      localBranches[27] = true;
      if (address.state != null) {
        localBranches[28] = true;
        return false;
      } else {
        localBranches[29] = true;
      }
    }

    if (zipCode != null) {
      localBranches[30] = true;
      return zipCode.equals(address.zipCode);
    } else {
      localBranches[31] = true;
      return address.zipCode == null;
    }
  }

  @Override
  public int hashCode() {
    int result = addressLineOne != null ? addressLineOne.hashCode() : 0;
    result = 31 * result + (addressLineTwo != null ? addressLineTwo.hashCode() : 0);
    result = 31 * result + (city != null ? city.hashCode() : 0);
    result = 31 * result + (state != null ? state.hashCode() : 0);
    result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Address{"
        + "addressLineOne='" + addressLineOne + '\''
        + ", addressLineTwo='" + addressLineTwo + '\''
        + ", city='" + city + '\''
        + ", state='" + state + '\''
        + ", zipCode='" + zipCode + '\''
        + '}';
  }
}
