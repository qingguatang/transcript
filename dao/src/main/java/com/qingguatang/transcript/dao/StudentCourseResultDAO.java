package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.StudentCourseResultDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentCourseResultDAO {

  /**
   * 根据课程ID删除记录
   */
  int deleteByCourseId(Long courseId);

  /**
   * 插入记录
   */
  int insert(StudentCourseResultDO record);
}
