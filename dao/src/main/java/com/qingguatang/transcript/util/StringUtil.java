package com.qingguatang.transcript.util;

/**
 * 字符串工具类
 *
 * @author joe
 * @date 2018/3/1
 */
public class StringUtil {

  /**
   * 格式化字符串，加上固定QGT-前缀
   * @param str
   * @return
   */
  public static String format(String str) {
    if (str == null) {
      return str;
    }
    str = "QGT-" + str.trim();

    return str;
  }

}
