package demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author joe
 * @date 2018/3/14
 */
@Configuration
@ComponentScan(basePackages = "demo")
@EnableAspectJAutoProxy
public class C {

  @Bean
  public User user() {
    return new User("joe");
  }

  public static void main(String[] args) {

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(C.class);
    context.registerShutdownHook();
  }

}
