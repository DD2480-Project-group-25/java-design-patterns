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

package com.iluwatar.spatialpartition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;

/**
 * The quadtree data structure is being used to keep track of the objects' locations.
 * It has the insert(Point) and query(range) methods to insert a new object and find
 * the objects within a certain (rectangular) range respectively.
 */

public class QuadTree {
  public static boolean[] coveredBranches = new boolean[8];
  boolean[] localCoveredBranches;
  Rect boundary;
  int capacity;
  boolean divided;
  Hashtable<Integer, Point> points;
  QuadTree northwest;
  QuadTree northeast;
  QuadTree southwest;
  QuadTree southeast;

  QuadTree(Rect boundary, int capacity) {
    this.boundary = boundary;
    this.capacity = capacity;
    this.divided = false;
    this.points = new Hashtable<Integer, Point>();
    this.northwest = null; 
    this.northeast = null;
    this.southwest = null; 
    this.southeast = null;
    localCoveredBranches = new boolean[8];
  }

  void insert(Point p) {
    if (!this.boundary.contains(p)) {
      // Counting if
      coveredBranches[0] = true;
      localCoveredBranches[0] = true;
      // Counting return
      coveredBranches[7] = true;
      localCoveredBranches[7] = true;
      return;
    } else {
      if (this.points.size() < this.capacity) {
        coveredBranches[1] = true;
        localCoveredBranches[1] = true;
        points.put(p.id, p);
      } else {
        if (!this.divided) {
          coveredBranches[2] = true;
          localCoveredBranches[2] = true;
          this.divide();
        }

        if (this.northwest.boundary.contains(p)) {
          coveredBranches[3] = true;
          localCoveredBranches[3] = true;
          this.northwest.insert(p);
        } else if (this.northeast.boundary.contains(p)) {
          coveredBranches[4] = true;
          localCoveredBranches[4] = true;
          this.northeast.insert(p);
        } else if (this.southwest.boundary.contains(p)) {
          coveredBranches[5] = true;
          localCoveredBranches[5] = true;
          this.southwest.insert(p);
        } else if (this.southeast.boundary.contains(p)) {
          coveredBranches[6] = true;
          localCoveredBranches[6] = true;
          this.southeast.insert(p);
        }
      }
    }
    //For checking what branches are missed in individual test cases
    //System.out.println(Arrays.toString(localCoveredBranches));
  }

  void divide() {
    Rect nw = new Rect(this.boundary.x - this.boundary.width / 4, this.boundary.y + this.boundary.height / 4, 
          this.boundary.width / 2, this.boundary.height / 2);
    this.northwest = new QuadTree(nw , this.capacity);
    Rect ne = new Rect(this.boundary.x + this.boundary.width / 4, this.boundary.y + this.boundary.height / 4, 
          this.boundary.width / 2, this.boundary.height / 2);
    this.northeast = new QuadTree(ne , this.capacity);
    Rect sw = new Rect(this.boundary.x - this.boundary.width / 4, this.boundary.y - this.boundary.height / 4, 
          this.boundary.width / 2, this.boundary.height / 2);
    this.southwest = new QuadTree(sw , this.capacity);
    Rect se = new Rect(this.boundary.x + this.boundary.width / 4, this.boundary.y - this.boundary.height / 4, 
          this.boundary.width / 2, this.boundary.height / 2);
    this.southeast = new QuadTree(se , this.capacity);
    this.divided = true;
  }

  ArrayList<Point> query(Rect r, ArrayList<Point> relevantPoints) {
    //could also be a circle instead of a rectangle
    if (this.boundary.intersects(r)) {
      for (Enumeration<Integer> e = this.points.keys(); e.hasMoreElements();) {
        Integer i = e.nextElement();
        if (r.contains(this.points.get(i))) {
          relevantPoints.add(this.points.get(i));
        }
      }
      if (this.divided) {
        this.northwest.query(r, relevantPoints);
        this.northeast.query(r, relevantPoints);
        this.southwest.query(r, relevantPoints);
        this.southeast.query(r, relevantPoints);
      }
    }
    return relevantPoints;
  }
}
