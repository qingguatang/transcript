package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.CourseDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * 课程数据服务
 */
@Mapper
public interface CourseDAO {

  /**
   * 根据课程ID查询课程数据
   */
  CourseDO selectByPrimaryKey(Long id);

}
