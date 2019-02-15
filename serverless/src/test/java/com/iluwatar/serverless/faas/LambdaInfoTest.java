package com.iluwatar.serverless.faas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for LambdaInfo, currently only testing equals()-method
 *
 * Created by helenaalinder 2/15-19
 */
public class LambdaInfoTest {

  /**
   * Compare LambdaInfo object with itself
   */
  @Test
  public void testEqualsSameObject() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    assertTrue(info1.equals(info1));
  }

  /**
   * Compare LambdaInfo object with null object
   */
  @Test
  public void testEqualsNullObject() {
    LambdaInfo info1 = createLambdaInfo(null, null,null,
        null,null,null);
    LambdaInfo info2 = null;
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare LambdaInfo object with object of other class
   */
  @Test
  public void testEqualsDifferentClass() {
    LambdaInfo info1 = createLambdaInfo(null,null,null,
        null,null,null);
    String info2 = "test";
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different awsRequestIds
   */
  @Test
  public void testEqualsRequestId() {
    LambdaInfo info1 = createLambdaInfo("1", null, null,
        null,null,null);
    LambdaInfo info2 = createLambdaInfo("2", null, null,
        null,null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null awsRequestId
   */
  @Test
  public void testEqualsThisNullRequestId() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo("1", null, null,
        null, null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different groupName
   */
  @Test
  public void testEqualsGroup() {
    LambdaInfo info1 = createLambdaInfo("1", "test1", null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo("1", "test2", null,
        null, null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null logGroupName
   */
  @Test
  public void testEqualsThisNullGroup() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, "test2", null,
        null, null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different logStreamName
   */
  @Test
  public void testEqualsStream() {
    LambdaInfo info1 = createLambdaInfo(null, "1", "test1",
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, "1", "test2",
        null, null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null logStreamName
   */
  @Test
  public void testEqualsThisNullStream() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, null, "test2",
        null, null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different functionName
   */
  @Test
  public void testEqualsFunc() {
    LambdaInfo info1 = createLambdaInfo(null, null, "1",
        "test1", null,null);
    LambdaInfo info2 = createLambdaInfo(null, null, "1",
        "test2", null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null functionName
   */
  @Test
  public void testEqualsThisNullFunc() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, null, null,
        "test2", null,null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different functionVersion
   */
  @Test
  public void testEqualsFuncVer() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        "1", "test1",null);
    LambdaInfo info2 = createLambdaInfo(null, null, null,
        "1", "test2",null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null functionVersion
   */
  @Test
  public void testEqualsThisNullFuncVer() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, null, null,
        null, "test2",null);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different memoryLimit
   */
  @Test
  public void testEqualsMemoryLimit() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, "1",1);
    LambdaInfo info2 = createLambdaInfo(null, null, null,
        null, "1",2);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null memoryLimit
   */
  @Test
  public void testEqualsThisNullMemoryLimit() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, null, null,
        null, null,2);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where both have null memoryLimit
   */
  @Test
  public void testEqualsBothNullMemoryLimit() {
    LambdaInfo info1 = createLambdaInfo(null, null, null,
        null, null,null);
    LambdaInfo info2 = createLambdaInfo(null, null, null,
        null, null,null);
    assertTrue(info1.equals(info2));
  }

  /**
   * Create LambdaInfo object for testing
   * @param id an awsRequestId
   * @param memory the memory limit in mb
   * @return LambdaInfo
   */
  private LambdaInfo createLambdaInfo(String id, String group, String stream,
                                      String func, String funcVer, Integer memory) {
    LambdaInfo info = new LambdaInfo();
    info.setAwsRequestId(id);
    info.setFunctionName(func);
    info.setFunctionVersion(funcVer);
    info.setLogGroupName(group);
    info.setLogStreamName(stream);
    info.setMemoryLimitInMb(memory);
    return info;
  }
}
