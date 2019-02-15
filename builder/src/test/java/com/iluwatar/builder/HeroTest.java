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
package com.iluwatar.builder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Date: 12/6/15 - 11:01 PM
 *
 * @author Jeroen Meulemeester
 */
public class HeroTest {

  @BeforeAll
  public static void setupCoverage() {
    Hero.coverage = new boolean[13];
    Hero.totalCoverage = new boolean[13];
  }

  /**
   * Print coverage and empty array
   */
  @AfterEach
  public void printAndCleanCoverage() {
    // If default is false, method has not been run, don't print
    if (Hero.coverage[12] == false) {
      return;
    }

    System.out.print("[");
    for (int i = 0; i < Hero.coverage.length; i++) {
      if (Hero.coverage[i] || Hero.totalCoverage[i]) {
        Hero.totalCoverage[i] = true;
      }
      if (i < Hero.coverage.length - 2) {
        System.out.print(Hero.CONDS[i] + " is " + Hero.coverage[i] + ", ");
      } else if (i == Hero.coverage.length - 1) {
        System.out.print(Hero.CONDS[i] + " is " + Hero.coverage[i]);
      }
      Hero.coverage[i] = false;
    }
    System.out.println("]");
    Arrays.fill(Hero.coverage, false);
  }

  /**
   * Print total coverage
   */
  @AfterAll
  public static void printCoverage() {
    System.out.println();
    System.out.println("Total coverage:");
    double coveredConds = 0;
    for (int i = 0; i < Hero.totalCoverage.length - 1; i++) {
      if (Hero.totalCoverage[i]) {
        System.out.println(Hero.CONDS[i] + " has been covered");
        coveredConds++;
      } else {
        System.out.println(Hero.CONDS[i] + " has not been covered");
      }
    }
    DecimalFormat df = new DecimalFormat("#.###");
    System.out.println("Covered " + df.format(coveredConds/Hero.totalCoverage.length)
        + "% of all conditions");
    System.out.println();

  }
  /**
   * Test if we get the expected exception when trying to create a hero without a profession
   */
  @Test
  public void testMissingProfession() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Hero.Builder(null, "Sir without a job"));
  }

  /**
   * Test if we get the expected exception when trying to create a hero without a name
   */
  @Test
  public void testMissingName() throws Exception {
    assertThrows(IllegalArgumentException.class, () -> new Hero.Builder(Profession.THIEF, null));
  }

  /**
   * Test if the hero build by the builder has the correct attributes, as requested
   */
  @Test
  public void testBuildHero() throws Exception {
    final String heroName = "Sir Lancelot";

    final Hero hero = new Hero.Builder(Profession.WARRIOR, heroName)
        .withArmor(Armor.CHAIN_MAIL)
        .withWeapon(Weapon.SWORD)
        .withHairType(HairType.LONG_CURLY)
        .withHairColor(HairColor.BLOND)
        .build();

    assertNotNull(hero);
    assertNotNull(hero.toString());
    assertEquals(Profession.WARRIOR, hero.getProfession());
    assertEquals(heroName, hero.getName());
    assertEquals(Armor.CHAIN_MAIL, hero.getArmor());
    assertEquals(Weapon.SWORD, hero.getWeapon());
    assertEquals(HairType.LONG_CURLY, hero.getHairType());
    assertEquals(HairColor.BLOND, hero.getHairColor());

  }
}
