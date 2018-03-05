package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.StudentDO;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Tests for {@link StudentDAO}.
 *
 * @author joe
 */
@RunWith(SpringRunner.class)
@MybatisTest
//@Import(DemoDao.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class StudentDaoTest {

  @Autowired
  private StudentDAO studentDAO;


  @Test
  public void insertTest() {

    StudentDO studentDO = new StudentDO();
    studentDO.setGender("male");
    studentDO.setId(System.currentTimeMillis());
    studentDO.setName("test");
    int result = studentDAO.insert(studentDO);

    assertThat(result > 0);

  }

  @Test
  public void batchInsertTest() {

    List<StudentDO> studentDOList = new ArrayList();

    StudentDO studentDO = new StudentDO();
    studentDO.setGender("male");
    studentDO.setId(123l);
    studentDO.setName("test");
    studentDOList.add(studentDO);

    studentDO = new StudentDO();
    studentDO.setGender("female");
    studentDO.setId(111l);
    studentDO.setName("test2");
    studentDOList.add(studentDO);

    int result = studentDAO.batchInsert(studentDOList);

    assertThat(result > 0);

  }

}
