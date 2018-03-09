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
 * <<<<<<< HEAD 课程成绩服务API
 *
 * @author joe
 * @author joe
 * @date 2018/3/7 =======
 * @date 2018/3/8 >>>>>>> 10
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
    resultResponses.forEach(studentResultResponse -> {

      Result result = new Result();

      //初始化student对象
      Student student = new Student();
      student.setGender(studentResultResponse.getGender());
      student.setId(studentResultResponse.getStudentId());
      student.setName(studentResultResponse.getStudentName());
      result.setStudent(student);
      //初始化course对象
      Course course = new Course();
      course.setId(studentResultResponse.getCourseId());
      course.setName(studentResultResponse.getCourseName());
      result.setCourse(course);

      result.setScore(studentResultResponse.getScore());
      result.setTestTime(studentResultResponse.getTestTime());

      results.add(result);

    });

    return results;
  }
}
