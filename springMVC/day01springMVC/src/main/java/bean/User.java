package bean;

import java.io.Serializable;

/**
 * user 用户
 * @author mly
 */
public class User implements Serializable {

    private  String clientName;
    private String sex;

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" + "clientName='" + clientName + '\'' + ", sex='" + sex + '\'' + '}';
    }
}
