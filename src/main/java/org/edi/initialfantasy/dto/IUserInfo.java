package org.edi.initialfantasy.dto;

/**
 * @author Fancy
 * @date 2018/8/24
 */
public interface IUserInfo {

    Integer getUserId();

    void setUserId(Integer value);

    String getUserName();

    void setUserName(String value);

    String getIsMobileUser();

    void setIsMobileUser(String value);

    Integer getCompanyId();

    void setCompanyId(Integer value);

    String getIsSupperUser();

    void setIsSupperUser(String isSupperUser);
}
