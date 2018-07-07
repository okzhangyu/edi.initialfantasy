package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2018/7/6.
 */
@Transactional
@Component(value="boRepositoryUser")
public class BORepositoryUser implements IBORepositoryUser {


    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserBySelect(String account, String password){
        return userMapper.getUserBySelect(account,password);
    }

    @Override
    public User getUserByCompanyId(String account,Integer companyId){
        return userMapper.getUserByCompanyId(account,companyId);
    }

    @Override
    public User getUserByName(String account){
        return userMapper.getUserByName(account);
    }

}
