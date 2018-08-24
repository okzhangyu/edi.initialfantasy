package org.edi.initialfantasy.dto;


import org.edi.initialfantasy.bo.user.User;

/**
 * @author Fancy
 * @date 2018/8/24
 */
public class UserInfo implements IUserInfo{

    public static UserInfo createUserInfo(User user){
        UserInfo userInfo = new UserInfo();
        userInfo.setCompanyId(user.getCompanyId());
        userInfo.setIsMobileUser(user.getIsMobileUser());
        userInfo.setIsSupperUser(user.getIsSupperUser());
        userInfo.setUserName(user.getUserName());
        userInfo.setUserId(user.getUserId());
        return userInfo;
    }
    private Integer userId;
    private String userName;
    private String isMobileUser;
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
    public String getIsMobileUser() {
        return isMobileUser;
    }

    @Override
    public void setIsMobileUser(String isMobileUser) {
        this.isMobileUser = isMobileUser;
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


    public UserInfo() {
    }



}
