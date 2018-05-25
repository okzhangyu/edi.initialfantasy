package org.edi.initialfantasy.repository;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IBORepositoryUser {
    /*
    检查用户是否存在
     */
    Boolean checkUser(String company,String username,String password);
}
