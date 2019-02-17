/**
 * The MIT License
 * Copyright (c) 2014 Ilkka Seppälä
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.collectionpipeline;

/**
 * A Car class that has the properties of make, model, year and category.
 */
public class Car {
  private final String make;
  private final String model;
  private final int year;
  private final Category category;
  public static boolean[] visitedBranchGlobal;
  public static boolean[] visitedBranchLocal;

  /**
   * Constructor to create an instance of car.
   *
   * @param make       the make of the car
   * @param model      the model of the car
   * @param yearOfMake the year of built of the car
   * @param category   the {@link Category} of the car
   */
  public Car(String make, String model, int yearOfMake, Category category) {
    this.make = make;
    this.model = model;
    this.year = yearOfMake;
    this.category = category;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category == null) ? 0 : category.hashCode());
    result = prime * result + ((make == null) ? 0 : make.hashCode());
    result = prime * result + ((model == null) ? 0 : model.hashCode());
    result = prime * result + year;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    // Branch 1
    if (this == obj) {
      visitedBranchLocal[0] = true;
      return true;
    }
    // Branch 2
    if (obj == null) {
      visitedBranchLocal[1] = true;
      return false;
    }
    // Branch 3
    if (getClass() != obj.getClass()) {
      visitedBranchLocal[2] = true;
      return false;
    }
    Car other = (Car) obj;

    // Branch 4
    if (category != other.category) {
      visitedBranchLocal[3] = true;
      return false;
    }
    // Branch 5
    if (make == null) {
      visitedBranchLocal[4] = true;
      // Branch 6
      if (other.make != null) {
        visitedBranchLocal[5] = true;
        return false;
      }
      // Branch 7
    } else if (!make.equals(other.make)) {
      visitedBranchLocal[6] = true;
      return false;
    }
    // Branch 8
    if (model == null) {
      visitedBranchLocal[7] = true;
      // Branch 9
      if (other.model != null) {
        visitedBranchLocal[8] = true;
        return false;
      }
      // Branch 10
    } else if (!model.equals(other.model)) {
      visitedBranchLocal[9] = true;
      return false;
    }
    // Branch 11
    if (year != other.year) {
      visitedBranchLocal[10] = true;
      return false;
    }
    // Branch 12
    visitedBranchLocal[11] = true;
    return true;
  }

  public String getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public Category getCategory() {
    return category;
  }
}