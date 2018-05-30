package org.edi.initialfantasy.service;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IUserService {

    String Login(String EncAccount,String EncPassword);

    String Logout(String logoutInfo);
}
