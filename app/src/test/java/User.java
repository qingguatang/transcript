
/**
 * @author joe
 * @date 2018/3/15
 */
public class User {

  private String userName;
  private String pwd;

  public User(String userName){
    this.userName = userName;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPwd() {
    return pwd;
  }

  public void setPwd(String pwd) {
    this.pwd = pwd;
  }
}
