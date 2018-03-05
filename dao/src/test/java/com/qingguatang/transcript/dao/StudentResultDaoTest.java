package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.StudentDO;
import com.qingguatang.transcript.dataobject.StudentResultDO;
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

    int result =studentResultDAO.batchInsert(studentResultDOS);
    assertThat(result > 0);

  }

}
