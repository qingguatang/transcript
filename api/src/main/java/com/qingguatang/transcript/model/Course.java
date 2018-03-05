package com.qingguatang.transcript.model;

/**
 * 课程模型
 * @author joe
 * @date 2018/3/5
 */
public class Course {

  private long id;
  //课程名称
  private String name;

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
}
