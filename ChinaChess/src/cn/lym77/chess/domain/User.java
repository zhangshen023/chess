package cn.lym77.chess.domain;
/**
 * created by shen on 2018/4/21
 */

/**
 * @since 2018/4/21
 * @author shen
 * @version 1.0.0
 */
public class User {

    private Integer userId;
    private String userName;
    private String pwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
