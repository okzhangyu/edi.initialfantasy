package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.dto.UserAuthrizationResult;
import org.edi.initialfantasy.mapper.UserAuthMapper;
import org.edi.initialfantasy.util.UUIDUtil;
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




    @Override
    public UserAuthrizationResult processUserLoginRecord(User user,long NextDayTimeMillis){
        UserAuthrizationResult uaResult = new UserAuthrizationResult();
        //查询用户历史登录记录
        UserAuth userRecord = userAuthMapper.serchLoginRecord(user.getUserName());
        String authToken = UUIDUtil.randomUUID19()+String.valueOf(NextDayTimeMillis);
        if(userRecord==null) {
            //没有用户记录则新建
            userRecord = new UserAuth(user.getUserName(), user.getIsMobileUser(), "客户", authToken, NextDayTimeMillis, "Y");
            userAuthMapper.saveLoginRecord(userRecord);
            uaResult = new UserAuthrizationResult(authToken,NextDayTimeMillis);
        }else{
            //存在用户记录则得到当前登录时间一天后的时间戳，更新
                UserAuth userAuth = new UserAuth(userRecord.getUserId(),NextDayTimeMillis);
                userAuthMapper.updateAuthExpires(userAuth);
                uaResult = new UserAuthrizationResult(authToken,NextDayTimeMillis);

            UserAuth uauth = new UserAuth(userRecord.getUserId(),authToken,"Y");
            userAuthMapper.updateActive(uauth);
        }
        return  uaResult;
    }





   /* @Override
    public UserAuthrizationResult processUserLoginRecord(User user,long NextDayTimeMillis){
        UserAuthrizationResult uaResult = new UserAuthrizationResult();
        //查询用户历史登录记录
        UserAuth userRecord = userAuthMapper.serchLoginRecord(user.getUserName());
        if(userRecord==null) {
            //没有用户记录则新建
            String authToken = UUIDUtil.randomUUID32();
            userRecord = new UserAuth(user.getUserName(), user.getIsMobileUser(), "客户", authToken, NextDayTimeMillis, "Y");
            userAuthMapper.saveLoginRecord(userRecord);
            uaResult = new UserAuthrizationResult(authToken,NextDayTimeMillis);
        }else{
            //存在用户记录则得到当前登录时间的时间戳，和记录时间戳进行比对，在有效期内则返回，否则更新
            Long currentTimeMillis = System.currentTimeMillis();
            if(currentTimeMillis<userRecord.getAuthExpires()){
                uaResult = new UserAuthrizationResult(userRecord.getAuthToken(),userRecord.getAuthExpires());
            }else{
                UserAuth userAuth = new UserAuth(userRecord.getUserId(),NextDayTimeMillis);
                userAuthMapper.updateAuthExpires(userAuth);
                uaResult = new UserAuthrizationResult(userRecord.getAuthToken(),NextDayTimeMillis);
            }
            UserAuth uauth = new UserAuth(userRecord.getUserId(),"Y");
            userAuthMapper.updateActive(uauth);
        }
        return  uaResult;
    }*/


}
