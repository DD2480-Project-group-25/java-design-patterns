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
package com.iluwatar.collectionpipeline;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Added tests for:
 * <ul>
 *   <li> Car object is equal to itself </li>
 *   <li> Comparing cars where one has null manufaturer returns false </li>
 *   <li> Car objects with different production year is not the same </li>
 *   <li> Comparing Car with null object returnsfalse </li>
 *   <li> Comparing Car with different object type returns false  </li>
 *   <li> Cars of from different categories are not the same  </li>
 *   <li> Cars with different manufacturers are not the same </li>
 *   <li> Comparing cars where one has null model returns false </li>
 * </ul>
 * Improves coverage of class Car from 41% to 91%
 *
 * Tests that Collection Pipeline methods work as expected.
 */
public class AppTest {
  
  private List<Car> cars = CarFactory.createCars();
  
  @Test
  public void testGetModelsAfter2000UsingFor() {
    List<String> models = ImperativeProgramming.getModelsAfter2000(cars);
    assertEquals(Arrays.asList("Avenger", "Wrangler", "Focus", "Cascada"), models);
  }
  
  @Test
  public void testGetModelsAfter2000UsingPipeline() {
    List<String> models = FunctionalProgramming.getModelsAfter2000(cars);
    assertEquals(Arrays.asList("Avenger", "Wrangler", "Focus", "Cascada"), models);
  }
  
  @Test
  public void testGetGroupingOfCarsByCategory() {
    Map<Category, List<Car>> modelsExpected = new HashMap<>();
    modelsExpected.put(Category.CONVERTIBLE, Arrays.asList(new Car("Buick", "Cascada", 2016, Category.CONVERTIBLE),
        new Car("Chevrolet", "Geo Metro", 1992, Category.CONVERTIBLE)));
    modelsExpected.put(Category.SEDAN, Arrays.asList(new Car("Dodge", "Avenger", 2010, Category.SEDAN),
        new Car("Ford", "Focus", 2012, Category.SEDAN)));
    modelsExpected.put(Category.JEEP, Arrays.asList(new Car("Jeep", "Wrangler", 2011, Category.JEEP),
        new Car("Jeep", "Comanche", 1990, Category.JEEP)));
    Map<Category, List<Car>> modelsFunctional = FunctionalProgramming.getGroupingOfCarsByCategory(cars);
    Map<Category, List<Car>> modelsImperative = ImperativeProgramming.getGroupingOfCarsByCategory(cars);
    System.out.println("Category " + modelsFunctional);
    assertEquals(modelsExpected, modelsFunctional);
    assertEquals(modelsExpected, modelsImperative);
  }
  
  @Test
  public void testGetSedanCarsOwnedSortedByDate() {
    Person john = new Person(cars);
    List<Car> modelsExpected = Arrays.asList(new Car("Dodge", "Avenger", 2010, Category.SEDAN), 
        new Car("Ford", "Focus", 2012, Category.SEDAN));
    List<Car> modelsFunctional = FunctionalProgramming.getSedanCarsOwnedSortedByDate(Arrays.asList(john));
    List<Car> modelsImperative = ImperativeProgramming.getSedanCarsOwnedSortedByDate(Arrays.asList(john));
    assertEquals(modelsExpected, modelsFunctional);
    assertEquals(modelsExpected, modelsImperative);
  }

  /**
   * Verify that a Car object is equals to itself.
   */
  @Test
  public void testEqualsSelf() {
    Car car = new Car("Toyota", "Prius", 2011, Category.SEDAN);
    assertTrue(car.equals(car));
  }

  /**
   * Verify that equals is false when one car has a "null" manufacturer.
   */
  @Test
  public void testOneCarNullMaker() {
    Car car1 = new Car(null, "Matrix", 2001, Category.JEEP);
    Car car2 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    assertFalse(car1.equals(car2));
    assertFalse(car2.equals(car1));
  }

  /**
   * Verify that two cars with different production years are not the same.
   */
  @Test
  public void testDifferentYears() {
    Car car1 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    Car car2 = new Car("Mazzerutzi", "Matrix", 2002, Category.JEEP);
    assertFalse(car1.equals(car2));
  }

  /**
   * Verify that comparison with null object returns false.
   */
  @Test
  public void testNullobject() {
    Car car1 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    assertFalse(car1.equals(null));
  }

  /**
   * Verify that comparison with object of different type returns false.
   */
  @Test
  public void testDifferentObjects() {
    Car car1 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    String str = "Hej";
    assertFalse(car1.equals(str));
  }

  /**
   * Verify that comparison with cars of different category returns false.
   */
  @Test
  public void testDifferentCategories() {
    Car car1 = new Car("Mazzerutzi", "Matrix", 2001, Category.SEDAN);
    Car car2 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    assertFalse(car1.equals(car2));

  }

  /**
   * Verify that comparison with cars produced by different manufacturers returns false.
   */
  @Test
  public void testDifferentMakers() {
    Car car1 = new Car("Volkeswagen", "Matrix", 2001, Category.JEEP);
    Car car2 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    assertFalse(car1.equals(car2));
  }

  /**
   * Verify that comparison with a car of null model returns false.
   * Tests that this holds for comparison in both ways.
   */
  @Test
  public void testNullModels() {
    Car car1 = new Car("Mazzerutzi", null, 2001, Category.JEEP);
    Car car2 = new Car("Mazzerutzi", "Matrix", 2001, Category.JEEP);
    assertFalse(car1.equals(car2));
    assertFalse(car2.equals(car1));
  }
}
