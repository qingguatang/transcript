package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.CourseDO;
import java.util.ArrayList;
import java.util.Calendar;
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
 * Tests for {@link CourseDAO}.
 *
 * @author joe
 */
@RunWith(SpringRunner.class)
@MybatisTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class CourseDaoTest {

  @Autowired
  private CourseDAO courseDAO;


  @Test
  public void insertTest() {
    CourseDO courseDO = new CourseDO();
    courseDO.setId(System.currentTimeMillis());
    courseDO.setName("qgt");
    int size = courseDAO.insert(courseDO);
    //预期结果大于0
    assertThat(size).isGreaterThan(0);
  }

  @Test
  public void updateTest() {
    CourseDO courseDO = new CourseDO();
    courseDO.setId(System.currentTimeMillis());
    courseDO.setName("qgt");
    int size = courseDAO.insert(courseDO);
    //预期结果大于0
    assertThat(size).isGreaterThan(0);

    courseDO.setName("qgttest  ");
    size = courseDAO.update(courseDO);
    assertThat(size).isGreaterThan(0);

    //再来查询一下
    courseDO = courseDAO.selectByPrimaryKey(courseDO.getId());
    assertThat(courseDO.getName()).isEqualTo("QGT-qgttest");

  }


  @Test
  public void deleteTest() {
    CourseDO courseDO = new CourseDO();
    courseDO.setId(System.currentTimeMillis());
    courseDO.setName("qgt");
    courseDAO.insert(courseDO);

    int size = courseDAO.deleteById(courseDO.getId());

    //预期结果大于0
    assertThat(size).isGreaterThan(0);
  }

  @Test
  public void batchInsertTest() {

    List<CourseDO> courseDOList = new ArrayList<>();

    CourseDO courseDO = new CourseDO();
    courseDO.setId(System.currentTimeMillis());
    courseDO.setName("qgt");
    courseDOList.add(courseDO);

    int size = courseDAO.bathInsert(courseDOList);
    //预期结果大于0
    assertThat(size).isGreaterThan(0);
  }


  @Test
  public void getTest() {
    CourseDO courseDO = courseDAO.selectByPrimaryKey(1l);
    assertThat(courseDO).isNotNull();
  }

  @Test
  public void selectByNameAndGmtTest() {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2018, 1, 1);
    Date time = calendar.getTime();

    CourseDO courseDO = courseDAO.selectByNameAndGmt("java", time);
    assertThat(courseDO).isNotNull();

  }


}
