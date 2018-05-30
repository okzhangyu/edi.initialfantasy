package org.edi.initialfantasy.bo.userauthrization;

/**
 * @author Fancy
 * 用户授权
 * @date 2018/5/17
 */
public class UserAuth implements IUserAuth {
    private String userId;
    private String authId;
    private String authType;
    private String authToken;
    private String authExpires;
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

    public String getAuthExpires() {
        return authExpires;
    }

    public void setAuthExpires(String authExpires) {
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

    public UserAuth(String userId, String authId, String authType, String authToken, String authExpires, String isActive) {
        this.userId = userId;
        this.authId = authId;
        this.authType = authType;
        this.authToken = authToken;
        this.authExpires = authExpires;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "UserAuth{" +
                "userId='" + userId + '\'' +
                ", authId='" + authId + '\'' +
                ", authType='" + authType + '\'' +
                ", authToken='" + authToken + '\'' +
                ", authExpires='" + authExpires + '\'' +
                ", isActive='" + isActive + '\'' +
                '}';
    }
}
