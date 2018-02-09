package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.StudentDO;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentDAO {
    int deleteByPrimaryKey(String id);

    int insert(StudentDO record);

    StudentDO selectByPrimaryKey(String id);

    List<StudentDO> selectAll();

    int updateByPrimaryKey(StudentDO record);
}
