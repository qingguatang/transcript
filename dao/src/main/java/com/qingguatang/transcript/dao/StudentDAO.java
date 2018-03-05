package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.StudentDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDAO {

  int delete(String id);

  /**
   * 插入记录
   */
  int insert(StudentDO record);

  /**
   * 批量插入
   */
  int batchInsert(List<StudentDO> records);


  /**
   * 修改学生记录
   */
  int update(StudentDO record);
}
