package com.iluwatar.serverless.baas.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Test class containing tests to increase the coverage
 * of Person.equals method.
 *
 * Previously tested requirements of Person.equals() (Coverage 0%) : None.
 * Previously untested but now tested requirements of Person.equals() (Coverage 100%):
 * - Compares identity
 * - If the input object is Null
 * - If the input object is not of class Person
 * - Compares firstName, lastName and address (both positive and negative tests)
 * - If firstName, lastName or address is Null
 */
public class PersonTest {
  /**
   * Test that equals() returns true when comparing the same object.
   */
  @Test
  public void testEqualsSameObject() {
    Person p = newPerson();
    Assert.assertTrue(p.equals(p));
  }

  /**
   * Test equals() with a null object as input.
   */
  @Test
  public void testEqualsNullObject() {
    Person p = newPerson();
    Person o = null;
    Assert.assertFalse(p.equals(o));
  }

  /**
   * Test equals() where the input object is not a Person.
   */
  @Test
  public void testDifferentClass() {
    Person p = newPerson();
    String s = new String();
    Assert.assertFalse(p.equals(s));
  }

  /**
   * Positive test for equal(). Same first name, last name and address.
   */
  @Test
  public void testEqualsPositive() {
    Person p1 = newPerson();
    Person p2 = newPerson();
    Assert.assertEquals("Thor", p2.getFirstName());
    Assert.assertEquals("Odinson", p2.getLastName());
    Assert.assertTrue(p1.equals(p2));
  }

  /**
   * Negative test for equal() where the first name differs.
   */
  @Test
  public void testEqualsNegativeFirstName() {
    Person p = newPerson();
    Person o = newPerson();
    o.setFirstName("Odin");
    Assert.assertFalse(p.equals(o));
  }

  /**
   * Negative test for equal() where the last name differs.
   */
  @Test
  public void testEqualsNegativeLastName() {
    Person p = newPerson();
    Person o = newPerson();
    o.setLastName("Odin");
    Assert.assertFalse(p.equals(o));
  }

  /**
   * Negative test for equal() where firstName is null.
   */
  @Test
  public void testNullFirstName() {
    Person p = new Person();
    p.setFirstName(null);
    Person o = newPerson();
    Assert.assertFalse(p.equals(o));
  }

  /**
   * Negative test for equal() where lastName is null.
   */
  @Test
  public void testNullLastName() {
    Person p = new Person();
    p.setFirstName("Thor");
    p.setLastName(null);
    Person o = newPerson();
    Assert.assertFalse(p.equals(o));
  }

  /**
   * Positive test for equal() when address is null.
   */
  @Test
  public void testAddressNullPositive() {
    Person p = new Person();
    p.setAddress(null);
    Person person = new Person();
    person.setAddress(null);
    Assert.assertEquals(null, person.getAddress());
    Assert.assertTrue(p.equals(person));
  }

  /**
   * Negative test for equal() address is null but person.address is not.
   */
  @Test
  public void testAddressNullNegative() {
    Person p = new Person();
    p.setAddress(null);
    Person person = new Person();
    Address a2 = new Address();
    a2.setAddressLineOne("1 Odin ln");
    a2.setCity("Asgard");
    a2.setState("country of the Gods");
    a2.setZipCode("00001");
    person.setAddress(a2);
    Assert.assertFalse(p.equals(person));
  }

  /**
   * Negative test for equal() when address is not null.
   */
  @Test
  public void testAddressNegative() {
    Person p = newPerson();
    Person person = new Person();
    Address a = new Address();
    a.setAddressLineOne("1 Odin");
    a.setCity("Asgar");
    a.setState("country");
    a.setZipCode("0000");
    person.setAddress(a);
    Assert.assertFalse(p.equals(person));
  }

  private Person newPerson() {
    Person person = new Person();
    person.setFirstName("Thor");
    person.setLastName("Odinson");
    Address address = new Address();
    address.setAddressLineOne("1 Odin ln");
    address.setCity("Asgard");
    address.setState("country of the Gods");
    address.setZipCode("00001");
    person.setAddress(address);

    return person;
  }
}
