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


    public User() {
    }

    public User(Integer userId, String userName, String password, String isMobileUser, String mobilePassword, Integer companyId) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.isMobileUser = isMobileUser;
        this.mobilePassword = mobilePassword;
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", isMobileUser='" + isMobileUser + '\'' +
                ", mobilePassword='" + mobilePassword + '\'' +
                ", companyId=" + companyId +
                '}';
    }
}
