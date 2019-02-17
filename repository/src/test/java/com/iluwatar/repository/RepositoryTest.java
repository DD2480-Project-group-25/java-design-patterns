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

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.google.common.collect.Lists;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test case to test the functions of {@link PersonRepository}, beside the CRUD functions, the query
 * by {@link org.springframework.data.jpa.domain.Specification} are also test.
 *
 * Previously tested requirements of Person.equals() (Coverage 24%) :
 * - Comparision of age.
 * - Positive instance, when compared objects are equal.
 Previously untested but now tested requirements of Person.equals() (Coverage 100%):
 * - Positive instances:
 *    - Compare object to self.
 *    - Compare equal objects that don't have first names or surnames.
 * - Negative instances:
 *    - Compare non-equal first names, surnames and id's.
 *    - Compare if one Person-object's first name, surname or id is null.
 *    - If input object is null.
 *    - If the input object is not of class Person.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class RepositoryTest {

  @Resource
  private PersonRepository repository;

  Person peter = new Person("Peter", "Sagan", 17);
  Person nasta = new Person("Nasta", "Kuzminova", 25);
  Person john = new Person("John", "lawrence", 35);
  Person terry = new Person("Terry", "Law", 36);

  List<Person> persons = Arrays.asList(peter, nasta, john, terry);

  /**
   * Prepare data for test
   */
  @BeforeEach
  public void setup() {

    repository.save(persons);
  }

  @Test
  public void testFindAll() {

    List<Person> actuals = Lists.newArrayList(repository.findAll());
    assertTrue(actuals.containsAll(persons) && persons.containsAll(actuals));
  }

  @Test
  public void testSave() {

    Person terry = repository.findByName("Terry");
    terry.setSurname("Lee");
    terry.setAge(47);
    repository.save(terry);

    terry = repository.findByName("Terry");
    assertEquals(terry.getSurname(), "Lee");
    assertEquals(47, terry.getAge());
  }

  @Test
  public void testDelete() {

    Person terry = repository.findByName("Terry");
    repository.delete(terry);

    assertEquals(3, repository.count());
    assertNull(repository.findByName("Terry"));
  }

  @Test
  public void testCount() {

    assertEquals(4, repository.count());
  }

  @Test
  public void testFindAllByAgeBetweenSpec() {

    List<Person> persons = repository.findAll(new PersonSpecifications.AgeBetweenSpec(20, 40));

    assertEquals(3, persons.size());
    assertTrue(persons.stream().allMatch(item -> item.getAge() > 20 && item.getAge() < 40));
  }

  @Test
  public void testFindOneByNameEqualSpec() {

    Person actual = repository.findOne(new PersonSpecifications.NameEqualSpec("Terry"));
    assertEquals(terry, actual);
  }

  /**
   * Tests positive instances for method Person.equals()
   */
  @Test
  public void compareToSelf() {
    Person p1 = new Person("John", "Johnsson", 20);
    assertTrue(p1.equals(p1));
  }

  @Test
  public void testEqualNullNames() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Johnsson", 20);
    p1.setName(null);
    p2.setName(null);
    assertTrue(p1.equals(p2));
  }

  @Test
  public void testEqualNullSurnames() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Johnsson", 20);
    p1.setSurname(null);
    p2.setSurname(null);
    assertTrue(p1.equals(p2));
  }

  /**
   * Tests negative instances for method Person.equals()
   */
  @Test
  public void testDifferentNames() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("Eric", "Johnsson", 20);
    assertFalse(p1.equals(p2));
  }

  @Test
  public void testDifferentSurnames() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Ericsson", 20);
    assertFalse(p1.equals(p2));
  }

  @Test
  public void testNoId() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Johnsson", 20);
    p1.setId((long) 1);
    assertFalse(p1.equals(p2));
    assertFalse(p2.equals(p1));
  }

  @Test
  public void testDifferentIds() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Johnsson", 20);
    p2.setId((long) 2);
    assertFalse(p1.equals(p2));
  }

  @Test
  public void testNameIsNull() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Johnsson", 20);
    p1.setName(null);
    assertFalse(p1.equals(p2));
    assertFalse(p2.equals(p1));
  }

  @Test
  public void testSurnameIsNull() {
    Person p1 = new Person("John", "Johnsson", 20);
    Person p2 = new Person("John", "Johnsson", 20);
    p1.setSurname(null);
    assertFalse(p1.equals(p2));
    assertFalse(p2.equals(p1));
  }

  @Test
  public void testObjectIsNull() {
    Person p1 = new Person("John", "Johnsson", 20);
    assertFalse(p1.equals(null));
  }

  @Test
  public void testNonPersonObject() {
    Person p1 = new Person("John", "Johnsson", 20);
    int notAPerson = 1;
    assertFalse(p1.equals(notAPerson));
  }

  @AfterEach
  public void cleanup() {
    repository.deleteAll();
  }

}
