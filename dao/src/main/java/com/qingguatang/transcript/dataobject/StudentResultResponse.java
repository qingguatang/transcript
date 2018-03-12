package com.qingguatang.transcript.dataobject;

/**
 * 学生成绩查询对象
 *
 * @author joe
 * @date 2018/3/5
 */
public class StudentResultResponse {

  private String studentName;
  private Long studentId;
  private String gender;
  private String courseName;
  private Long courseId;
  private int score;
  private long testTime;
  private long studentResultId;

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public Long getStudentId() {
    return studentId;
  }

  public void setStudentId(Long studentId) {
    this.studentId = studentId;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getCourseName() {
    return courseName;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public Long getCourseId() {
    return courseId;
  }

  public void setCourseId(Long courseId) {
    this.courseId = courseId;
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

  public long getStudentResultId() {
    return studentResultId;
  }

  public void setStudentResultId(long studentResultId) {
    this.studentResultId = studentResultId;
  }
}
