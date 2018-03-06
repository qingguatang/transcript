package com.qingguatang.transcript.model;


/**
 * 学生测试结果查询模型
 * @author joe
 * @date 2018/3/5
 */
public class StudentResultQueryParam {

  /**
   * 性别
   */
  private String gender;
  /**
   * 是否通过
   */
  private Boolean passed;

  /**
   * 课程ID
   */
  private long courseId;

  /**
   * 排序字段
   */
  private String orderByAttr;
  /**
   * 排序类型
   */
  private String sortOrder;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public Boolean getPassed() {
    return passed;
  }

  public void setPassed(Boolean passed) {
    this.passed = passed;
  }

  public long getCourseId() {
    return courseId;
  }

  public void setCourseId(long courseId) {
    this.courseId = courseId;
  }

  public String getOrderByAttr() {
    return orderByAttr;
  }

  public void setOrderByAttr(String orderByAttr) {
    this.orderByAttr = orderByAttr;
  }

  public String getSortOrder() {
    return sortOrder;
  }

  public void setSortOrder(String sortOrder) {
    this.sortOrder = sortOrder;
  }
}
