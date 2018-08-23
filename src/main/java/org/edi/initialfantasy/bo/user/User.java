package org.edi.initialfantasy.bo.user;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public class User implements IUser {
    private Integer userId;
    private String userName;
    private String password;
    private String isMobileUser;
    private String mobilePassword;
    private Integer companyId;
    private String isSupperUser;

    @Override
    public Integer getUserId() {
        return userId;
    }

    @Override
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getIsMobileUser() {
        return isMobileUser;
    }

    @Override
    public void setIsMobileUser(String isMobileUser) {
        this.isMobileUser = isMobileUser;
    }

    public String getMobilePassword() {
        return mobilePassword;
    }

    public void setMobilePassword(String mobilePassword) {
        this.mobilePassword = mobilePassword;
    }

    @Override
    public Integer getCompanyId() {
        return companyId;
    }

    @Override
    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String getIsSupperUser() {
        return isSupperUser;
    }

    @Override
    public void setIsSupperUser(String isSupperUser) {
        this.isSupperUser = isSupperUser;
    }


    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "userId:" + userId +
                ", userName:'" + userName + '\'' +
                ", password:'" + password + '\'' +
                ", isMobileUser:'" + isMobileUser + '\'' +
                ", mobilePassword:'" + mobilePassword + '\'' +
                ", isSupperUser:'" + isSupperUser + '\'' +
                ", companyId:" + companyId +
                '}';
    }
}
