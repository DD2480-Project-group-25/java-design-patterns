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
package com.iluwatar.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Arrays;

/**
 * 
 * Person entity
 *
 */
@Entity
public class Person {

  @Id
  @GeneratedValue
  private Long id;
  private String name;
  private String surname;

  private int age;
  static boolean[] coveredBranches = new boolean[14];
  static boolean[] localCoveredBranches = new boolean[14];

  public Person() {
  }

  /**
   * Constructor
   */
  public Person(String name, String surname, int age) {
    this.name = name;
    this.surname = surname;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  @Override
  public String toString() {
    return "Person [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + "]";
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + (id == null ? 0 : id.hashCode());
    result = prime * result + (name == null ? 0 : name.hashCode());
    result = prime * result + (surname == null ? 0 : surname.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      localCoveredBranches[0] = true;
      return true;
    }
    if (obj == null) {
      localCoveredBranches[1] = true;
      return false;
    }
    if (getClass() != obj.getClass()) {
      localCoveredBranches[2] = true;
      return false;
    }
    Person other = (Person) obj;
    if (age != other.age) {
      localCoveredBranches[3] = true;
      return false;
    }
    if (id == null) {
      localCoveredBranches[4] = true;
      if (other.id != null) {
        localCoveredBranches[5] = true;
        return false;
      }
    } else if (!id.equals(other.id)) {
      localCoveredBranches[6] = true;
      return false;
    }
    if (name == null) {
      localCoveredBranches[7] = true;
      if (other.name != null) {
        localCoveredBranches[8] = true;
        return false;
      }
    } else if (!name.equals(other.name)) {
      localCoveredBranches[9] = true;
      return false;
    }
    if (surname == null) {
      localCoveredBranches[10] = true;
      if (other.surname != null) {
        localCoveredBranches[11] = true;
        return false;
      }
    } else if (!surname.equals(other.surname)) {
      localCoveredBranches[12] = true;
      return false;
    }
    localCoveredBranches[13] = true;
    
    //for tracking of individual test cases coverage
    //System.out.println(Arrays.toString(localCoveredBranches));
    return true;
  }

}
