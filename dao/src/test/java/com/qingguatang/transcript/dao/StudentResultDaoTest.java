package com.qingguatang.transcript.dao;

import static org.assertj.core.api.Assertions.assertThat;

import com.qingguatang.transcript.dataobject.CourseDO;
import com.qingguatang.transcript.dataobject.StudentCourseResultDO;
import com.qingguatang.transcript.dataobject.StudentDO;
import com.qingguatang.transcript.dataobject.StudentResultDO;
import com.qingguatang.transcript.dataobject.StudentResultResponse;
import com.qingguatang.transcript.model.StudentResultQueryParam;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Before;
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
  @Autowired
  private StudentDAO studentDAO;
  @Autowired
  private CourseDAO courseDAO;
  @Autowired
  private StudentCourseResultDAO studentCourseResultDAO;

  /**
   * 初始化数据
   */
  @Before
  public void init() {
    //随便取一个随机ID
    long baseID = System.currentTimeMillis();
    //先插入学生记录
    StudentDO studentDO = new StudentDO();
    studentDO.setName("焦哥");
    studentDO.setId(baseID+1);
    studentDO.setGender("男");
    studentDAO.insert(studentDO);
    //插入课程数据
    CourseDO courseDO = new CourseDO();
    courseDO.setName("青瓜堂");
    courseDO.setId(baseID+2);
    courseDAO.insert(courseDO);
    //插入学生课程关联数据
    StudentCourseResultDO studentCourseResultDO = new StudentCourseResultDO();
    studentCourseResultDO.setId(baseID+3);
    studentCourseResultDO.setStudentId(studentDO.getId());
    studentCourseResultDO.setCourseId(courseDO.getId());
    studentCourseResultDAO.insert(studentCourseResultDO);
    //插入课程成绩
    StudentResultDO studentResultDO = new StudentResultDO();
    studentResultDO.setId(baseID+4);
    studentResultDO.setScore(59d);
    studentResultDO.setTesttime(new Date());
    studentResultDO.setStudentCourseId(studentCourseResultDO.getId());
    studentResultDAO.insert(studentResultDO);

  }

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
    queryParam.setGender("男");
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
    assertThat(resultResponses.size()).isEqualTo(1);
  }


}
