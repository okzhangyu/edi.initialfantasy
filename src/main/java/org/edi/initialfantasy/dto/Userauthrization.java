package org.edi.initialfantasy.dto;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 用户登陆授权传输对象
 */
@XmlRootElement(name = "Userauthrization")
public class Userauthrization {

    private String companyName;

    private String userName;

    private String password;

    public String getCompanyName(){return this.companyName;}
    public void setCompanyName(String value){this.companyName = value;}

    public String getUserName(){return this.userName;}
    public void setUserName(String value){this.userName = value;}

    public String getPassword(){return this.password;}
    public void setPassword(String value){this.password = value;}


}
