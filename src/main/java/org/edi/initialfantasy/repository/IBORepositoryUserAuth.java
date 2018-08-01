package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.dto.UserAuthrizationResult;

/**
 * Created by asus on 2018/7/6.
 */
public interface IBORepositoryUserAuth {
    void saveLoginRecord(UserAuth userAuth);
    UserAuth serchLoginRecord(String userName);
    void updateAuthExpires(UserAuth userAuth);
    void updateActive(UserAuth userAuth);
    UserAuth serchAuthByToken(String token);
    public UserAuthrizationResult processUserLoginRecord(User user, long nextDayTimeMillis);
}
