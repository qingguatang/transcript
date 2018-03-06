package com.qingguatang.transcript.dao;

import com.qingguatang.transcript.dataobject.StudentResultDO;
import com.qingguatang.transcript.dataobject.StudentResultResponse;
import com.qingguatang.transcript.model.StudentResultQueryParam;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * 学生成绩DAO
 */
@Mapper
public interface StudentResultDAO {

    public List<StudentResultResponse> query(StudentResultQueryParam param);

    /**
     * 删除学生成绩
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 插入学生成绩
     * @param record
     * @return
     */
    int insert(StudentResultDO record);

    /**
     * 批量添加
     * @param records
     * @return
     */
    int batchInsert(List<StudentResultDO> records);

    /**
     * 修改学生成绩
     * @param record
     * @return
     */
    int update(StudentResultDO record);
}
