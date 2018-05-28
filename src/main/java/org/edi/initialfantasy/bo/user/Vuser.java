package org.edi.initialfantasy.bo.user;

import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@SuppressWarnings("restriction")
@XmlRootElement
public class Vuser implements Serializable {
    private Integer id;
    private String user_name;
    private String password;
    private String is_mobile_user;
    private String mobile_password;

    public Vuser() {
        super();
    }

    public Vuser(Integer id, String user_name, String password, String is_mobile_user, String mobile_password) {
        super();
        this.id = id;
        this.user_name = user_name;
        this.password = password;
        this.is_mobile_user = is_mobile_user;
        this.mobile_password = mobile_password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_mobile_user() {
        return is_mobile_user;
    }

    public void setIs_mobile_user(String is_mobile_user) {
        this.is_mobile_user = is_mobile_user;
    }

    public String getMobile_password() {
        return mobile_password;
    }

    public void setMobile_password(String mobile_password) {
        this.mobile_password = mobile_password;
    }

    @Override
    public String toString() {
        return "Vuser [id=" + id + ", user_name=" + user_name + ", password=" + password + ", is_mobile_user="
                + is_mobile_user + ", mobile_password=" + mobile_password + "]";
    }


}
