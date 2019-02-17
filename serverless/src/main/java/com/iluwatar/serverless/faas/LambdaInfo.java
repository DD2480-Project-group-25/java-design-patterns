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
package com.iluwatar.serverless.faas;

import java.io.Serializable;

/**
 * Lambda context information
 */
public class LambdaInfo implements Serializable {

  public static boolean[] coverage = new boolean[37];
  public static boolean[] totalCoverage = new boolean[37];
  public static final String[] CONDS = {"this == o", "this != o", "o == null",
      "o != null", "getClass() != o.getClass()",
      "o != null && getClass() == o.getClass()", "awsRequestId != null",
      "!awsRequestId.equals(that.awsRequestId)",
      "awsRequestId.equals(that.awsRequestId)", "that.awsRequestId != null",
      "awsRequestId == null && that.awsRequestId == null",
      "logGroupName != null", "!logGroupName.equals(that.logGroupName)",
      "logGroupName.equals(that.logGroupName)", "that.logGroupName != null",
      "logGroupName == null && that.logGroupName == null",
      "logStreamName != null", "!logStreamName.equals(that.logStreamName)",
      "logStreamName.equals(that.logStreamName)",
      "that.logStreamName != null",
      "logStreamName == null && that.logStreamName == null",
      "functionName != null", "!functionName.equals(that.functionName)",
      "functionName.equals(that.functionName)", "that.functionName != null",
      "functionName == null && that.functionName == null",
      "functionVersion != null",
      "!functionVersion.equals(that.functionVersion)",
      "functionVersion.equals(that.functionVersion)",
      "that.functionVersion != null",
      "functionVersion == null && that.functionVersion == null",
      "memoryLimitInMb != null",
      "memoryLimitInMb.equals(that.memoryLimitInMb)",
      "!memoryLimitInMb.equals(that.memoryLimitInMb)",
      "that.memoryLimitInMb == null",
      "memoryLimitInMb == null && "
          + "that.memoryLimitInMb != null", "default"};
  private static final long serialVersionUID = 3936130599040848923L;

  private String awsRequestId;
  private String logGroupName;
  private String logStreamName;
  private String functionName;
  private String functionVersion;
  private Integer memoryLimitInMb;

  public String getAwsRequestId() {
    return awsRequestId;
  }

  public void setAwsRequestId(String awsRequestId) {
    this.awsRequestId = awsRequestId;
  }

  public String getLogGroupName() {
    return logGroupName;
  }

  public void setLogGroupName(String logGroupName) {
    this.logGroupName = logGroupName;
  }

  public String getLogStreamName() {
    return logStreamName;
  }

  public void setLogStreamName(String logStreamName) {
    this.logStreamName = logStreamName;
  }

  public String getFunctionName() {
    return functionName;
  }

  public void setFunctionName(String functionName) {
    this.functionName = functionName;
  }

  public String getFunctionVersion() {
    return functionVersion;
  }

  public void setFunctionVersion(String functionVersion) {
    this.functionVersion = functionVersion;
  }

  public Integer getMemoryLimitInMb() {
    return memoryLimitInMb;
  }

  public void setMemoryLimitInMb(Integer memoryLimitInMb) {
    this.memoryLimitInMb = memoryLimitInMb;
  }

  @Override
  public String toString() {
    return "LambdaInfo{"
        + "awsRequestId='" + awsRequestId + '\''
        + ", logGroupName='" + logGroupName + '\''
        + ", logStreamName='" + logStreamName + '\''
        + ", functionName='" + functionName + '\''
        + ", functionVersion='" + functionVersion + '\''
        + ", memoryLimitInMb=" + memoryLimitInMb
        + '}';
  }

  @Override
  public boolean equals(Object o) {
    boolean validObj = true;
    boolean sameClass = true;
    coverage[36] = true;
    if (this == o) {
      coverage[0] = true;
    } else {
      coverage[1] = true;
    }
    if (o == null || getClass() != o.getClass()) {
      if (o == null) {
        coverage[2] = true;
        validObj = false;
      } else {
        coverage[3] = true;
        coverage[4] = true;
        sameClass = false;
      }
    } else {
      coverage[5] = true;
    }

    if (validObj && sameClass) {
      LambdaInfo that1 = (LambdaInfo) o;

      if (awsRequestId != null) {
        coverage[6] = true;
        if (!awsRequestId.equals(that1.awsRequestId)) {
          coverage[7] = true;
        } else {
          coverage[8] = true;
        }
      } else if (that1.awsRequestId != null) {
        coverage[9] = true;
      } else {
        coverage[10] = true;
      }

      if (logGroupName != null) {
        coverage[11] = true;
        if (!logGroupName.equals(that1.logGroupName)) {
          coverage[12] = true;
        } else {
          coverage[13] = true;
        }
      } else if (that1.logGroupName != null) {
        coverage[14] = true;
      } else {
        coverage[15] = true;
      }

      if (logStreamName != null) {
        coverage[16] = true;
        if (!logStreamName.equals(that1.logStreamName)) {
          coverage[17] = true;
        } else {
          coverage[18] = true;
        }
      } else if (that1.logStreamName != null) {
        coverage[19] = true;
      } else {
        coverage[20] = true;
      }

      if (functionName != null) {
        coverage[21] = true;
        if (!functionName.equals(that1.functionName)) {
          coverage[22] = true;
        } else {
          coverage[23] = true;
        }
      } else if (that1.functionName != null) {
        coverage[24] = true;
      } else {
        coverage[25] = true;
      }

      if (functionVersion != null) {
        coverage[26] = true;
        if (!functionVersion.equals(that1.functionVersion)) {
          coverage[27] = true;
        } else {
          coverage[28] = true;
        }
      } else if (that1.functionVersion != null) {
        coverage[29] = true;
      } else {
        coverage[30] = true;
      }

      if (memoryLimitInMb != null) {
        coverage[31] = true;
        if (memoryLimitInMb.equals(that1.memoryLimitInMb)) {
          coverage[32] = true;
        } else {
          coverage[33] = true;
        }
      } else if (that1.memoryLimitInMb == null) {
        coverage[34] = true;
      } else {
        coverage[35] = true;
      }
    }


    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LambdaInfo that = (LambdaInfo) o;

    if (awsRequestId != null ? !awsRequestId.equals(that.awsRequestId) : that.awsRequestId != null) {
      return false;
    }
    if (logGroupName != null ? !logGroupName.equals(that.logGroupName) : that.logGroupName != null) {
      return false;
    }
    if (logStreamName != null ? !logStreamName.equals(that.logStreamName) : that.logStreamName != null) {
      return false;
    }
    if (functionName != null ? !functionName.equals(that.functionName) : that.functionName != null) {
      return false;
    }
    if (functionVersion != null ? !functionVersion.equals(that.functionVersion) : that.functionVersion != null) {
      return false;
    }
    return memoryLimitInMb != null ? memoryLimitInMb.equals(that.memoryLimitInMb) : that.memoryLimitInMb == null;
  }

  @Override
  public int hashCode() {
    int result = awsRequestId != null ? awsRequestId.hashCode() : 0;
    result = 31 * result + (logGroupName != null ? logGroupName.hashCode() : 0);
    result = 31 * result + (logStreamName != null ? logStreamName.hashCode() : 0);
    result = 31 * result + (functionName != null ? functionName.hashCode() : 0);
    result = 31 * result + (functionVersion != null ? functionVersion.hashCode() : 0);
    result = 31 * result + (memoryLimitInMb != null ? memoryLimitInMb.hashCode() : 0);
    return result;
  }
}
