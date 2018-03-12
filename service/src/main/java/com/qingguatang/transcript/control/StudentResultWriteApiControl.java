package com.qingguatang.transcript.control;

import com.qingguatang.transcript.api.StudentResultWriteApi;
import com.qingguatang.transcript.dao.CourseDAO;
import com.qingguatang.transcript.dao.StudentCourseResultDAO;
import com.qingguatang.transcript.dao.StudentDAO;
import com.qingguatang.transcript.dao.StudentResultDAO;
import com.qingguatang.transcript.dataobject.CourseDO;
import com.qingguatang.transcript.dataobject.StudentCourseResultDO;
import com.qingguatang.transcript.dataobject.StudentDO;
import com.qingguatang.transcript.dataobject.StudentResultDO;
import com.qingguatang.transcript.dataobject.StudentResultResponse;
import com.qingguatang.transcript.model.StudentResultQueryParam;
import com.qingguatang.transcript.model.UploadResult;
import com.qingguatang.transcript.util.PoiUtil;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author joe
 * @date 2018/3/12
 */
@Controller
public class StudentResultWriteApiControl implements StudentResultWriteApi {

  private static final Logger logger = LoggerFactory.getLogger(StudentResultWriteApiControl.class);


  @Autowired
  private StudentResultDAO studentResultDAO;
  @Autowired
  private StudentDAO studentDAO;
  @Autowired
  private CourseDAO courseDAO;
  @Autowired
  private StudentCourseResultDAO studentCourseResultDAO;


  @RequestMapping(path = "/api/upload", produces = {"application/json"})
  @ResponseBody
  @Override
  public UploadResult upload(@RequestParam("file") MultipartFile multipartFile) {
    UploadResult result = new UploadResult();

    String fileName = multipartFile.getOriginalFilename();
    InputStream in = null;
    try {
      in = multipartFile.getInputStream();
    } catch (IOException e) {
      logger.error("", e);
      result.setErrorMessage(e.getMessage());
      result.setSuccess(false);
      return result;
    }
    //解析Excel
    List<StudentResultResponse> responseList = PoiUtil.read(fileName, in);
    //查询历史数据
    List<StudentResultResponse> oldResponseList = studentResultDAO
        .query(new StudentResultQueryParam());
    Map<Long, StudentResultResponse> oldResponseMap = new HashMap<>();
    //转换为map关系
    oldResponseList.forEach(response -> {
      oldResponseMap.put(response.getStudentId(), response);
    });
    Long courseId = null;
    for (StudentResultResponse response : responseList) {
      courseId = initData(oldResponseMap, courseId, response);
    }

    result.setTotal(responseList.size());
    result.setSuccess(true);

    return result;
  }

  /**
   * 执行数据初始化
   * @param oldResponseMap
   * @param courseId
   * @param response
   * @return
   */
  private Long initData(Map<Long, StudentResultResponse> oldResponseMap, Long courseId,
      StudentResultResponse response) {
    //如果已经有数据
    if (oldResponseMap.containsKey(response.getStudentId())) {
      StudentResultResponse response1 = oldResponseMap.get(response.getStudentId());
      StudentResultDO resultDO = new StudentResultDO();
      resultDO.setId(response1.getStudentResultId());
      resultDO.setScore(Double.valueOf(response.getScore()));
      studentResultDAO.update(resultDO);
      courseId = response.getCourseId();
    } else {
      //先插入学生记录
      StudentDO studentDO = new StudentDO();
      studentDO.setName(response.getStudentName());
      studentDO.setId(response.getStudentId());
      studentDO.setGender(response.getGender());
      studentDAO.insert(studentDO);
      if (courseId == null) {
        //插入课程数据
        CourseDO courseDO = new CourseDO();
        courseDO.setName(response.getCourseName());
        courseDO.setId(System.currentTimeMillis());
        courseDAO.insert(courseDO);
        courseId = courseDO.getId();
      }

      //插入学生课程关联数据
      StudentCourseResultDO studentCourseResultDO = new StudentCourseResultDO();
      studentCourseResultDO.setId(studentDO.getId() + courseId);
      studentCourseResultDO.setStudentId(studentDO.getId());
      studentCourseResultDO.setCourseId(courseId);
      studentCourseResultDAO.insert(studentCourseResultDO);
      //插入课程成绩
      StudentResultDO studentResultDO = new StudentResultDO();
      studentResultDO.setId(studentDO.getId() + courseId);
      studentResultDO.setScore(Double.valueOf(response.getScore()));
      studentResultDO.setTesttime(new Date());
      studentResultDO.setStudentCourseId(studentCourseResultDO.getId());
      studentResultDAO.insert(studentResultDO);

    }
    return courseId;
  }
}
