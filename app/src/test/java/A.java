import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author joe
 * @date 2018/3/14
 */
public class A implements ApplicationContextAware, InitializingBean {

  private String name = "joe";
  private ApplicationContext applicationContext;

  public void init() {
    System.out.println("init-method");
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    B b = (B) applicationContext.getBean("b");
    b.say();
  }

  public void close() {
    System.out.println("close");
  }


}
