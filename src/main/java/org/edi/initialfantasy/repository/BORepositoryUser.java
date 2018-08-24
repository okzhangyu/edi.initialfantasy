package org.edi.initialfantasy.repository;

import org.edi.freamwork.data.operation.OpResultCode;
import org.edi.freamwork.data.operation.OpResultDescription;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

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
     * @param company
     * @return
     */
    @Override
    public User getUserByCompany(String account,String company){
        try{
            HashMap<String,String> paramMap = new HashMap<>();
            paramMap.put("userName",account);
            paramMap.put("companyName",company);
            User user = userMapper.getUserByCompany(paramMap);
            return user;
        } catch (BusinessException e){
            throw e;
        }
        catch (Exception e){
            e.printStackTrace();
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
