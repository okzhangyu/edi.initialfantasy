package org.edi.initialfantasy.mapper;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;

/**
 * Created by asus on 2018/5/30.
 */
public interface UserAuthMapper {
    void saveAuth(UserAuth userAuth);
    UserAuth serchAuth(Integer userId);
    void updateAuth(UserAuth userAuth);
    UserAuth serchAuthByToken(String token);
}
