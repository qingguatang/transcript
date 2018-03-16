
/**
 * @author joe
 * @date 2018/3/14
 */
public class B {

  private A a;

  public void say() {
    System.out.println("Hello " + a.getName());
  }

  public A getA() {
    return a;
  }

  public void setA(A a) {
    this.a = a;
  }
}
