package org.edi.initialfantasy.bo.user;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public interface IUser {

    Integer getUserId();

    void setUserId(Integer value);

    String getUserName();

    void setUserName(String value);

    String getPassword();

    void setPassword(String value);

    String getIsMobileUser();

    void setIsMobileUser(String value);


    Integer getCompanyId();

    void setCompanyId(Integer value);

    String getIsSupperUser();

    void setIsSupperUser(String isSupperUser);
}
