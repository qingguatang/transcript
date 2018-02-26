package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.CourseDO;
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

}
