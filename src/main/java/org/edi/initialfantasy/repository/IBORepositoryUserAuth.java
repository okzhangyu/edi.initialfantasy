package org.edi.initialfantasy.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.dto.UserAuthrizationResult;

/**
 * Created by asus on 2018/7/6.
 */
public interface IBORepositoryUserAuth {
    void saveAuth(UserAuth userAuth);
    void updateAuth(UserAuth userAuth);
    UserAuth serchAuthByToken(String token);
    UserAuthrizationResult getAuthrization(String companyName,String userName,String password)  throws Exception ,BusinessException;
    UserAuthrizationResult flushAuthrization(User user, long nextDayTimeMillis);
}
