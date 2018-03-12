package com.qingguatang.transcript.control;

import com.qingguatang.transcript.api.StudentResultWriteApi;
import com.qingguatang.transcript.model.UploadResult;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author joe
 * @date 2018/3/9
 */
@Controller
public class StudentResultWriteApiControl implements StudentResultWriteApi {

  @RequestMapping(path = "/api/upload", produces = {"application/json"})
  @ResponseBody
  @Override
  public UploadResult upload(@RequestParam("file") MultipartFile file) {
    UploadResult result = new UploadResult();
    try {
      InputStream in = file.getInputStream();
      List<String> lines = IOUtils.readLines(in, "utf-8");
      result.setTotal(lines.size());
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }
}
