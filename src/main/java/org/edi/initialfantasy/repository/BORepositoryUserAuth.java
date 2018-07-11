package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.mapper.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2018/7/6.
 */

@Transactional
@Component(value="boRepositoryUserAuth")
public class BORepositoryUserAuth implements  IBORepositoryUserAuth {


    @Autowired
    private UserAuthMapper userAuthMapper;


    @Override
    public void saveLoginRecord(UserAuth userAuth){
         userAuthMapper.saveLoginRecord(userAuth);
    }

    @Override
    public UserAuth serchLoginRecord(String userName){
         return userAuthMapper.serchLoginRecord(userName);
    }

    @Override
    public void updateAuthExpires(UserAuth userAuth){
        userAuthMapper.updateAuthExpires(userAuth);
    }

    @Override
    public void updateActive(UserAuth userAuth){
        userAuthMapper.updateActive(userAuth);
    }

    @Override
    public UserAuth serchAuthByToken(String token){
        return userAuthMapper.serchAuthByToken(token);
    }


}
