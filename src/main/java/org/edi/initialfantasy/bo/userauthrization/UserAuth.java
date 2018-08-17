package org.edi.initialfantasy.bo.userauthrization;

import org.edi.freamwork.bo.SimpleBO;

/**
 * @author Fancy
 * 用户授权
 * @date 2018/5/17
 */
public class UserAuth extends SimpleBO implements IUserAuth {
    private String userId;
    private String authId;
    private String authType;
    private String authToken;
    private Long authExpires;
    private String isActive;

    @Override
    public String getUserId() {
        return userId;
    }

    @Override
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String getAuthId() {
        return authId;
    }

    @Override
    public void setAuthId(String authId) {
        this.authId = authId;
    }

    @Override
    public String getAuthType() {
        return authType;
    }

    @Override
    public void setAuthType(String authType) {
        this.authType = authType;
    }

    @Override
    public String getAuthToken() {
        return authToken;
    }

    @Override
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Long getAuthExpires() {
        return authExpires;
    }

    @Override
    public void setAuthExpires(Long authExpires) {
        this.authExpires = authExpires;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public UserAuth() {
    }

    public UserAuth(String userId, String authId, String authType, String authToken, Long authExpires, String isActive) {
        this.userId = userId;
        this.authId = authId;
        this.authType = authType;
        this.authToken = authToken;
        this.authExpires = authExpires;
        this.isActive = isActive;
    }

    public UserAuth(String userId,Long authExpires) {
        this.userId = userId;
        this.authExpires = authExpires;

    }

    public UserAuth(String userId,String isActive) {
        this.userId = userId;
        this.isActive = isActive;
    }

    public UserAuth(String userId,String authToken,String isActive) {
        this.userId = userId;
        this.authToken = authToken;
        this.isActive = isActive;
    }
    @Override
    public String toString() {
        return "UserAuth{" +
                "userId='" + userId + '\'' +
                ", authId='" + authId + '\'' +
                ", authType='" + authType + '\'' +
                ", authToken='" + authToken + '\'' +
                ", authExpires=" + authExpires +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
