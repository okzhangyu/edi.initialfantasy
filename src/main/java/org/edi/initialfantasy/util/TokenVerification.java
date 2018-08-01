package org.edi.initialfantasy.util;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.UserAuthMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/7/4.
 */

@Component(value="tokenVerification")
public class TokenVerification {
    @Autowired
    private UserAuthMapper userAuthMapper;

    public  String verification(String token){
        if(token == null || token.isEmpty()){
            return ResultDescription.TOKEN_IS_EMPTY;
        }
        UserAuth userAuth = userAuthMapper.serchAuthByToken(token);
        if(userAuth == null){
            return ResultDescription.TOKEN_IS_ERROR;
        }
        if(userAuth.getAuthExpires()<System.currentTimeMillis()){
            return ResultDescription.TOKEN_IS_INVAILD;
        }
        if(userAuth.getIsActive().trim().equals("Y")){
            return ResultDescription.OK;
        }else {
            return ResultDescription.TOKEN_IS_EXPIRED;
        }

    }

}