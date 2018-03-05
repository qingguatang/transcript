package com.qingguatang.transcript.model;

/**
 * 上传结果模型
 *
 * @author joe
 * @date 2018/3/5
 */
public class UploadResult {

  /**
   * 总记录数
   */
  private int total;
  /**
   * 是否成功
   */
  private boolean isSuccess;
  /**
   * 错误码
   */
  private String errorCode;
  /**
   * 错误消息
   */
  private String errorMessage;

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }

  public boolean isSuccess() {
    return isSuccess;
  }

  public void setSuccess(boolean success) {
    isSuccess = success;
  }

  public String getErrorCode() {
    return errorCode;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }
}
