package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.CourseDO;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 课程数据服务
 */
@Mapper
public interface CourseDAO {

  /**
   * 修改
   * @param courseDO
   * @return
   */
  int update(CourseDO courseDO);

  /**
   * 根据ID删除数据
   * @param id
   * @return
   */
  int deleteById(long id);

  /**
   * 插入记录
   * @param courseDO
   * @return
   */
  int insert(CourseDO courseDO);


  /**
   * 批量插入记录
   * @param courseDOs
   * @return
   */
  int bathInsert(List<CourseDO> courseDOs);

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
