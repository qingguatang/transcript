package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.CourseDO;
import java.util.Calendar;
import java.util.Date;
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
