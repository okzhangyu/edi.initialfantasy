package org.edi.initialfantasy.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/7/6.
 */

@Component(value="boRepositoryUser")
public class BORepositoryUser implements IBORepositoryUser {


    @Autowired
    private UserMapper userMapper;

    /**
     * 账户密码查询用户
     * @param account
     * @param password
     * @return
     */
    @Override
    public User getUserBySelect(String account, String password){
        return userMapper.getUserBySelect(account,password);
    }

    /**
     * 账户公司查询用户
     * @param account
     * @param companyId
     * @return
     */
    @Override
    public User getUserByCompanyId(String account,Integer companyId){
        User user = userMapper.getUserByCompanyId(account,companyId);
        if(user==null){
            throw new BusinessException(ResultDescription.USER_IS_NONEXISTENT);
        }
        return user;
    }

    /**
     * 名字查询用户
     * @param account
     * @return
     */
    @Override
    public User getUserByName(String account){
        return userMapper.getUserByName(account);
    }

}
