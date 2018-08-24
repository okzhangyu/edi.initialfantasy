package org.edi.initialfantasy.dto;

import org.edi.initialfantasy.bo.user.User;

public class UserAuthrizationResult implements IUserAuthrizationResult{

    private String token;
    private Long expires;
    private UserInfo userInfo;
    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public void setToken(String value) {
        this.token = value;
    }

    @Override
    public Long getExpires() {
        return this.expires;
    }

    @Override
    public void setExpires(Long value) {
        this.expires = value;
    }

    public UserAuthrizationResult() {
    }

    @Override
    public UserInfo getUserInfo(){
        return userInfo;
    }

    @Override
    public void setUserInfo(UserInfo userInfo){
        this.userInfo = userInfo;
    }

}
