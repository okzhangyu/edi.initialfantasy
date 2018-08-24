package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.user.User;

/**
 * Created by asus on 2018/7/6.
 */
public interface IBORepositoryUser {
    User getUserBySelect(String account, String password);
    User getUserByCompany(String account,String company);
    User getUserByName(String account);
    User getUserByToken(String token);
}
