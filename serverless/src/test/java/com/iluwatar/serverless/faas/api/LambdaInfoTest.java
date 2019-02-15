package com.iluwatar.serverless.faas.api;

import com.iluwatar.serverless.faas.LambdaInfo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    LambdaInfo info1 = createLambdaInfo("1", 1);
    assertTrue(info1.equals(info1));
  }

  /**
   * Compare LambdaInfo object with null object
   */
  @Test
  public void testEqualsNullObject() {
    LambdaInfo info1 = createLambdaInfo("1", 1);
    LambdaInfo info2 = null;
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare LambdaInfo object with object of other class
   */
  @Test
  public void testEqualsDifferentClass() {
    LambdaInfo info1 = createLambdaInfo("1",1);
    String info2 = "test";
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects with different awsRequestIds
   */
  @Test
  public void testEqualsDifferentRequestId() {
    LambdaInfo info1 = createLambdaInfo("1", 1);
    LambdaInfo info2 = createLambdaInfo("2", 1);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where this object has null awsRequestId
   */
  @Test
  public void testEqualsThisNullRequestId() {
    LambdaInfo info1 = createLambdaInfo(null, 1);
    LambdaInfo info2 = createLambdaInfo("1", 1);
    assertFalse(info1.equals(info2));
  }

  /**
   * Compare two LambdaInfo objects where both has null awsRequestIds
   */
  @Test
  public void testEqualsOtherNullRequestId() {
    LambdaInfo info1 = createLambdaInfo(null, 1);
    LambdaInfo info2 = createLambdaInfo(null, 1);
    assertTrue(info1.equals(info2));
  }
  /**
   * Compare two LambdaInfo objects with different memoryLimit
   */
  @Test
  public void testEqualsDifferentMemoryLimit() {
    LambdaInfo info1 = createLambdaInfo("1", 1);
    LambdaInfo info2 = createLambdaInfo("1", 2);
    assertFalse(info1.equals(info2));
  }

  /**
   * Create LambdaInfo object for testing
   * @param id an awsRequestId
   * @param memory the memory limit in mb
   * @return LambdaInfo
   */
  private LambdaInfo createLambdaInfo(String id, int memory) {
    LambdaInfo info = new LambdaInfo();
    info.setAwsRequestId(id);
    info.setFunctionName("test1");
    info.setFunctionVersion("test2");
    info.setLogGroupName("test3");
    info.setLogStreamName("test4");
    info.setMemoryLimitInMb(memory);
    return info;
  }
}
