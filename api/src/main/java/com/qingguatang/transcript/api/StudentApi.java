package com.qingguatang.transcript.api;

import com.qingguatang.transcript.model.ClassInfo;

/**
 * 学生API
 */
public interface StudentApi {

  /**
   * 班级基本信息
   * @return
   */
  public ClassInfo queryForClassInfo();


}
