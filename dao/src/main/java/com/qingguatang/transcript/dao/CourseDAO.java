package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.CourseDO;
import java.util.Date;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 课程数据服务
 */
@Mapper
public interface CourseDAO {

  /**
   * 根据课程ID查询课程数据
   */
  CourseDO selectByPrimaryKey(Long id);

  /**
   * 根据名称和时间查询
   * @param name
   * @param time
   * @return
   */
  CourseDO selectByNameAndGmt(@Param("name") String name,@Param("time") Date time);

}
