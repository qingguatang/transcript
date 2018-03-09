package com.qingguatang.transcript.control;

import com.qingguatang.transcript.api.StudentResultApi;
import com.qingguatang.transcript.dao.StudentResultDAO;
import com.qingguatang.transcript.dataobject.StudentResultResponse;
import com.qingguatang.transcript.model.Course;
import com.qingguatang.transcript.model.Result;
import com.qingguatang.transcript.model.Student;
import com.qingguatang.transcript.model.StudentResultQueryParam;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 课程成绩服务API
 *
 * @author joe
 * @date 2018/3/7
 */
@Controller
public class StudentResultApiControl implements StudentResultApi {

  @Autowired
  private StudentResultDAO studentResultDAO;

  @RequestMapping(path = "/api/studentresults", produces = {"application/json"})
  @ResponseBody
  @Override
  public List<Result> query(StudentResultQueryParam param) {

    List<Result> results = new ArrayList<>();

    if (param == null) {
      param = new StudentResultQueryParam();
    }
    List<StudentResultResponse> resultResponses = studentResultDAO.query(param);
    if (resultResponses == null) {
      return results;
    }
    //循环数据库返回结果
    resultResponses.forEach(studentResultResponse -> {
      Result result = new Result();
      //初始化学生对象
      Student student = new Student();
      student.setName(studentResultResponse.getStudentName());
      student.setId(studentResultResponse.getStudentId());
      student.setGender(studentResultResponse.getGender());
      result.setStudent(student);
      //初始化课程对象
      Course course = new Course();
      course.setName(studentResultResponse.getCourseName());
      course.setId(studentResultResponse.getCourseId());
      result.setCourse(course);

      result.setTestTime(studentResultResponse.getTestTime());
      result.setScore(studentResultResponse.getScore());

      results.add(result);
    });

    return results;
  }
}
