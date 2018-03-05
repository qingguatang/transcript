package com.qingguatang.transcript.model;

/**
 * 学生模型
 * @author joe
 * @date 2018/2/5
 */
public class Student {

  private long id;
  //学生名称
  private String name;
  //学生性别
  private String gender;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}
