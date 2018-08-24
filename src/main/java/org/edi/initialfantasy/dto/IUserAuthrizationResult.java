package org.edi.initialfantasy.dto;


public interface IUserAuthrizationResult {

    String getToken();

    void setToken(String value);

    Long getExpires();

    void setExpires(Long value);

    UserInfo getUserInfo();

    void setUserInfo(UserInfo user);
}
