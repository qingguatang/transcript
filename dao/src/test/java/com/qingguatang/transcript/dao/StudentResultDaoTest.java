package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.StudentResultDO;
import com.qingguatang.transcript.dataobject.StudentResultResponse;
import com.qingguatang.transcript.model.StudentResultQueryParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link StudentResultDAO}.
 *
 * @author joe
 */
@RunWith(SpringRunner.class)
@MybatisTest
//@Import(DemoDao.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentResultDaoTest {

  @Autowired
  private StudentResultDAO studentResultDAO;


  @Test
  public void batchInsertTest() {

    List<StudentResultDO> studentResultDOS = new ArrayList();

    StudentResultDO studentResultDO = new StudentResultDO();
    studentResultDO.setId(1l);
    studentResultDO.setScore(88d);
    studentResultDO.setStudentCourseId(1l);
    studentResultDO.setTesttime(new Date());
    studentResultDOS.add(studentResultDO);

    int result = studentResultDAO.batchInsert(studentResultDOS);
    assertThat(result > 0);

  }

  @Test
  public void queryTest() {
    StudentResultQueryParam queryParam = new StudentResultQueryParam();
    // 不及格的人数
    //queryParam.setPassed(false);
    //queryParam.setOrderByAttr("score");
    //queryParam.setSortOrder("asc");
    List<StudentResultResponse> resultResponses = studentResultDAO.query(queryParam);
    //第一个分数大于第二个
   // assertThat(resultResponses.get(0).getScore()).isGreaterThan(resultResponses.get(1).getScore());
    //没有不及格人数
    // assertThat(resultResponses.size()).isEqualTo(0);
    //默认记录是2
    assertThat(resultResponses.size()).isEqualTo(2);
  }


}
