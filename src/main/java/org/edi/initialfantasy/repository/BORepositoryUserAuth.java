package org.edi.initialfantasy.repository;

import org.edi.freamwork.bo.BusinessObject;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.cryptogram.MD5Util;
import org.edi.freamwork.data.operation.OpResultCode;
import org.edi.freamwork.data.operation.OpResultDescription;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.dto.UserAuthrizationResult;
import org.edi.initialfantasy.dto.UserInfo;
import org.edi.initialfantasy.mapper.CompanyMapper;
import org.edi.initialfantasy.mapper.UserAuthMapper;
import org.edi.initialfantasy.mapper.UserMapper;
import org.edi.initialfantasy.util.UUIDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * Created by asus on 2018/7/6.
 */


@Component(value="boRepositoryUserAuth")
public class BORepositoryUserAuth implements  IBORepositoryUserAuth {


    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private CompanyMapper companyMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public void saveAuth(UserAuth userAuth){
        try{
            userAuthMapper.saveAuth(userAuth);
        }catch (Exception e){
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }


    @Override
    public void updateAuth(UserAuth userAuth){
        try {
            userAuthMapper.updateAuth(userAuth);
        }catch (Exception e){
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }


    @Override
    public UserAuth serchAuthByToken(String token){
        try {
            return userAuthMapper.serchAuthByToken(token);
        }catch (Exception e){
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }

    @Override
    public UserAuthrizationResult getAuthrization(String companyName, String userName, String password) throws Exception ,BusinessException{
        HashMap<String,String> paramMap = new HashMap<>();
        paramMap.put("userName",userName);
        paramMap.put("companyName",companyName);
        User loginUser =  userMapper.getUserByCompany(paramMap);
        if(loginUser == null){
            throw new BusinessException(ResultCode.USER_IS_NONEXISTENT,ResultDescription.USER_IS_NONEXISTENT);
        }
        String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(loginUser.getMobilePassword().getBytes(),"avatech"));
        if (hmacPassword.equals(password)) {
            long NextDayTimeMillis = Long.parseLong(DataConvert.dateToStamp());
            UserAuthrizationResult userAuthrizationResult = flushAuthrization(loginUser,NextDayTimeMillis);
            return userAuthrizationResult;
        } else {
            throw new BusinessObjectException(ResultCode.USERPASSWORD_IS_ERROR,ResultDescription.USERPASSWORD_IS_ERROR);
        }
    }


    @Override
    public UserAuthrizationResult flushAuthrization(User user,long NextDayTimeMillis){
        try {
            UserAuthrizationResult uaResult = new UserAuthrizationResult();
            uaResult.setUserInfo(UserInfo.createUserInfo(user));
            //查询用户历史登录记录
            UserAuth userRecord = userAuthMapper.serchAuth(user.getUserId());
            String authToken = UUIDUtil.randomUUID19() + String.valueOf(NextDayTimeMillis);
            uaResult.setExpires(NextDayTimeMillis);
            uaResult.setToken(authToken);
            if (userRecord == null) {
                userRecord = new UserAuth(user.getUserId(), String.valueOf(user.getUserId()), "客户", authToken, NextDayTimeMillis, "Y");
                userAuthMapper.saveAuth(userRecord);
            } else {
                //存在用户记录则得到当前登录时间一天后的时间戳，更新
                userRecord.setAuthExpires(NextDayTimeMillis);
                userRecord.setIsActive("Y");
                userRecord.setAuthToken(authToken);
                userAuthMapper.updateAuth(userRecord);
            }
            return uaResult;
        }catch (Exception e){
            e.printStackTrace();
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }
    }
}
