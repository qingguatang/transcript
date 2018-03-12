package com.qingguatang.transcript.api;

import com.qingguatang.transcript.model.UploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 学生成绩写入服务
 * @author joe
 * @date 2018/3/5
 */
public interface StudentResultWriteApi {

  /**
   * 上传服务 #TODO  需要添加Spring mvc依赖
   * @return
   */
  public UploadResult upload( MultipartFile file);

}
