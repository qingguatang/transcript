package com.qingguatang.transcript.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @RequestMapping(value = "/")
  public String index() {
    return "Hello 青瓜堂!";
  }
}