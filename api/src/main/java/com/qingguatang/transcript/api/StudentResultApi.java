package com.qingguatang.transcript.api;

import com.qingguatang.transcript.model.Result;
import com.qingguatang.transcript.model.StudentResultQueryParam;
import java.util.List;

/**
 * 学生成绩API
 * @author joe
 * @date 2018/3/5
 */
public interface StudentResultApi {

  /**
   * 查询API
   * @param param
   * @return
   */
  public List<Result> query(StudentResultQueryParam param);

}
