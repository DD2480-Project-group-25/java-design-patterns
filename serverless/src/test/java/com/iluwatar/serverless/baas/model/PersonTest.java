package com.iluwatar.serverless.baas.model;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

/**
 * Created by alzahraasalman on 2019-02-15.
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
