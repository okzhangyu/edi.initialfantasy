package org.edi.initialfantasy.repository;

import org.edi.freamwork.data.operation.OpResultCode;
import org.edi.freamwork.data.operation.OpResultDescription;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
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
        try{
            return userMapper.getUserBySelect(account,password);
        }catch (Exception e){
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }

    /**
     * 账户公司查询用户
     * @param account
     * @param companyId
     * @return
     */
    @Override
    public User getUserByCompanyId(String account,Integer companyId){
        try{
            User user = userMapper.getUserByCompanyId(account,companyId);
            if(user==null){
                throw new BusinessException(ResultDescription.USER_IS_NONEXISTENT);
            }
            return user;
        }catch (Exception e){
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }

    /**
     * 名字查询用户
     * @param account
     * @return
     */
    @Override
    public User getUserByName(String account){
        try {
            return userMapper.getUserByName(account);
        }catch (Exception e){
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }

}
