package com.iluwatar.serverless.baas.model;

import org.junit.Assert;
import org.junit.jupiter.api.*;

/**
 * Test Addresses for equality
 */
public class AddressTest {
  @Test
  void positive() {
    Address a1 = new Address();
    Address a2 = new Address();

    Assert.assertEquals(a1, a2);
  }

  @Test
  void sameObject() {
    Address a = new Address();

    Assert.assertEquals(a, a);
  }

  @Test
  void otherNull() {
    Address a = new Address();

    Assert.assertNotEquals(a, null);
  }

  @Test
  void addressLineOneDiffers() {
    Address a1 = new Address();
    a1.setAddressLineOne("Foo");
    Address a2 = new Address();
    a2.setAddressLineOne("Bar");

    Assert.assertNotEquals(a1, a2);
  }

  @Test
  void addressLineTwoDiffers() {
    Address a1 = new Address();
    a1.setAddressLineTwo("Foo");
    Address a2 = new Address();
    a2.setAddressLineTwo("Bar");

    Assert.assertNotEquals(a1, a2);
  }

  @Test
  void cityDiffers() {
    Address a1 = new Address();
    a1.setCity("Foo");
    Address a2 = new Address();
    a2.setCity("Bar");

    Assert.assertNotEquals(a1, a2);
  }

  @Test
  void stateDiffers() {
    Address a1 = new Address();
    a1.setState("Foo");
    Address a2 = new Address();
    a2.setState("Bar");

    Assert.assertNotEquals(a1, a2);
  }

  @Test
  void zipCodeDiffers() {
    Address a1 = new Address();
    a1.setZipCode("Foo");
    Address a2 = new Address();
    a2.setZipCode("Bar");

    Assert.assertNotEquals(a1, a2);
  }

  @Test
  void addressLineOneSame() {
    Address a1 = new Address();
    a1.setAddressLineOne("Foo");
    Address a2 = new Address();
    a2.setAddressLineOne("Foo");

    Assert.assertEquals(a1, a2);
  }

  @Test
  void addressLineTwoSame() {
    Address a1 = new Address();
    a1.setAddressLineTwo("Foo");
    Address a2 = new Address();
    a2.setAddressLineTwo("Foo");

    Assert.assertEquals(a1, a2);
  }

  @Test
  void citySame() {
    Address a1 = new Address();
    a1.setCity("Foo");
    Address a2 = new Address();
    a2.setCity("Foo");

    Assert.assertEquals(a1, a2);
  }

  @Test
  void stateSame() {
    Address a1 = new Address();
    a1.setState("Foo");
    Address a2 = new Address();
    a2.setState("Foo");

    Assert.assertEquals(a1, a2);
  }

  @Test
  void zipCodeSame() {
    Address a1 = new Address();
    a1.setZipCode("Foo");
    Address a2 = new Address();
    a2.setZipCode("Foo");

    Assert.assertEquals(a1, a2);
  }

  @Test
  void otherClass() {
    Address a = new Address();
    String s = "";

    Assert.assertNotEquals(a, s);
  }
}
