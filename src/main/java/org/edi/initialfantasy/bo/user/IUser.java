package org.edi.initialfantasy.bo.user;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public interface IUser {

    String getUserId();

    void setUserId(String value);

    String getCompanyId();

    void setCompanyId(String value);

    String getDeptId();

    void setDeptId(String value);

    String getUserName();

    void setUserName(String value);

    String getPassword();

    void setPassword(String value);

    String getIsMobileUser();

    void setIsMobileUser(String value);
}
