package com.qingguatang.transcript;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.qingguatang.transcript", "com.qingguatang.transcript.control",
    "com.qingguatang.transcript.service.impl"})
public class TranscriptApplication {

  public static void main(String[] args) {
    SpringApplication.run(TranscriptApplication.class, args);
  }
}
