package com.qingguatang.transcript.model;

/**
 * 班级基本信息
 *
 * @author joe
 * @date 2018/3/5
 */
public class ClassInfo {

  /**
   * 班级总人数
   */
  private int total;
  /**
   * 男生人数
   */
  private int maleCount;
  /**
   * 女生人数
   */
  private int femaleCount;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public int getMaleCount() {
    return maleCount;
  }

  public void setMaleCount(int maleCount) {
    this.maleCount = maleCount;
  }

  public int getFemaleCount() {
    return femaleCount;
  }

  public void setFemaleCount(int femaleCount) {
    this.femaleCount = femaleCount;
  }
}
