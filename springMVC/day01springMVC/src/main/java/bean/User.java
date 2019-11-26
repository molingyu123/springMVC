package bean;

import java.io.Serializable;
import java.util.Date;

/**
 * user 用户
 * @author mly
 */
public class User implements Serializable {

    private  String clientName;
    private String sex;
    private Date date;

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" + "clientName='" + clientName + '\'' + ", sex='" + sex + '\'' + ", date=" + date + '}';
    }
}
