package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.StudentDO;
import java.util.List;

public interface StudentDAO {
    int deleteByPrimaryKey(String id);

    int insert(StudentDO record);

    StudentDO selectByPrimaryKey(String id);

    List<StudentDO> selectAll();

    int updateByPrimaryKey(StudentDO record);
}