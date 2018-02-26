package com.qingguatang.transcript.service.impl;

import com.qingguatang.transcript.dao.CourseDAO;
import com.qingguatang.transcript.dataobject.CourseDO;
import com.qingguatang.transcript.service.CourseService;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author joe
 * @date 2018/2/26
 */
public class CourseServiceImpl implements CourseService {

  @Autowired
  private CourseDAO courseDAO;

  /**
   * 课程名称的缓存
   */
  private static ConcurrentMap<String, String> courseNameCache = new ConcurrentHashMap<>();

  @Override
  public String getCourseName(String courseId) {

    if (courseNameCache.containsKey(courseId)) {
      return courseNameCache.get(courseId);
    }

    CourseDO courseDO = courseDAO.selectByPrimaryKey(Long.valueOf(courseId));
    if (courseDO == null) {
      return null;
    }
    courseNameCache.put(courseId, courseDO.getName());
    return courseDO.getName();
  }
}
