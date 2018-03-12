package com.qingguatang.transcript.util;

import com.qingguatang.transcript.dataobject.StudentResultResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author joe
 * @date 2018/3/10
 */
public class PoiUtil {

  private static final Logger logger = LoggerFactory.getLogger(PoiUtil.class);

  public static List<StudentResultResponse> read(String fileName, InputStream in) {

    List<StudentResultResponse> responses = new ArrayList<>();

    Workbook workbook = getWorkbook(fileName, in);
    //取第一个sheet即可
    Sheet sheet = workbook.getSheetAt(0);

    for (int i = 1; i <= sheet.getLastRowNum(); i++) {
      Row row = sheet.getRow(i);
      StudentResultResponse response = new StudentResultResponse();
      responses.add(response);
      for (int j = 0; j < row.getLastCellNum(); j++) {
        initCell(row, response, j);
      }
    }
    return responses;
  }

  private static void initCell(Row row, StudentResultResponse response, int j) {
    Cell cell = row.getCell(j);
    String value = null;

    if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
      value = String.valueOf(Double.valueOf(cell.getNumericCellValue()).intValue());
    } else {
      value = cell.getStringCellValue();
    }
    switch (j) {
      case 0:
        //第一个学号是数字类型
        response.setStudentId(Long.valueOf(value));
        break;
      case 1:
        //学生名册
        response.setStudentName(value);
        break;
      case 2:
        //学生性别
        response.setGender(value);
        break;
      case 3:
        //课程
        response.setCourseName(value);
        break;
      case 4:
        //成绩
        response.setScore(Integer.parseInt(value));
        break;
    }
  }


  public static Workbook getWorkbook(String fileName, InputStream in) {
    try {
      if (StringUtils.endsWith(fileName, "xls")) {
        return new HSSFWorkbook(in);
      } else {
        return new XSSFWorkbook(in);
      }
    } catch (IOException e) {
      logger.error("", e);
    }
    return null;
  }

  public static void main(String[] args) throws Exception {

    URL url = new URL("http://qgt-document.oss-cn-beijing.aliyuncs.com/transcript/data.xlsx");
    URLConnection connection = url.openConnection();
    InputStream in = connection.getInputStream();
    String filename = "data.xlsx";

    List<StudentResultResponse> responses = read(filename, in);

    System.out.println(responses.size());

  }

}
