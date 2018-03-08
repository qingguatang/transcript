package com.qingguatang.transcript.control;

import com.qingguatang.transcript.api.StudentApi;
import com.qingguatang.transcript.dao.StudentDAO;
import com.qingguatang.transcript.dataobject.StudentDO;
import com.qingguatang.transcript.model.ClassInfo;
import com.qingguatang.transcript.model.Student;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author joe
 * @date 2018/2/5
 */
@Controller
public class StudentApiControl implements StudentApi{

  @Autowired
  private StudentDAO studentDAO;

  @RequestMapping(path = "/api/studentclass" ,produces = {"application/json"})
  @ResponseBody
  @Override
  public ClassInfo queryForClassInfo() {
    ClassInfo classInfo = new ClassInfo();

    List<StudentDO> studentDOList =studentDAO.selectAll();
    classInfo.setTotal(studentDOList.size());
    int maleSize = 0;
    int femaleSize = 0;
    for (StudentDO studentDO:studentDOList){
      if(StringUtils.equals(studentDO.getGender().toLowerCase(),"male")){
        maleSize++;
      }else{
        femaleSize++;
      }
    }

    classInfo.setMaleCount(maleSize);
    classInfo.setFemaleCount(femaleSize);

    return classInfo;
  }
}
