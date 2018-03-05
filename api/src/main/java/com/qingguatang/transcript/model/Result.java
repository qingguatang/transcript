package com.qingguatang.transcript.model;

/**
 * 测试结果模型
 * @author joe
 * @date 2018/3/5
 */
public class Result {

  /**
   * 学生模型
   */
  private Student student;
  /**
   * 课程模型
   */
  private Course course;
  /**
   * 分数
   */
  private int score;
  /**
   * 测试时间
   */
  private long testTime;

  public Student getStudent() {
    return student;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public Course getCourse() {
    return course;
  }

  public void setCourse(Course course) {
    this.course = course;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public long getTestTime() {
    return testTime;
  }

  public void setTestTime(long testTime) {
    this.testTime = testTime;
  }
}
