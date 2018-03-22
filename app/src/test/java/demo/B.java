package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author joe
 * @date 2018/3/14
 */
@Service
public class B {

  @Autowired
  private A a;

  public void say() {
    System.out.println("Hello " + a.getName());
  }

}
