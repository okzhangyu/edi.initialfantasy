package org.edi.initialfantasy.util;

import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.dto.AuthrizationException;
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

    public  void verification(String token){
        if(token == null || token.isEmpty()){
            throw new AuthrizationException(ResultCode.TOKEN_IS_EMPTY,ResultDescription.TOKEN_IS_EMPTY);
        }
        UserAuth userAuth = userAuthMapper.serchAuthByToken(token);
        if(userAuth == null){
            throw new AuthrizationException(ResultCode.TOKEN_IS_ERROR,ResultDescription.TOKEN_IS_ERROR);
        }
        if(userAuth.getAuthExpires() < System.currentTimeMillis()){
            throw new AuthrizationException(ResultCode.TOKEN_IS_EXPIRED,ResultDescription.TOKEN_IS_EXPIRED);
        }
    }

}