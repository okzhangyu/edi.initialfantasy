package org.edi.initialfantasy.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.IUserAuthrization;
import org.edi.initialfantasy.dto.IUserAuthrizationRes;



/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IUserService {

    IResult<IUserAuthrizationRes> Login(IUserAuthrization userauthrization);

    String Logout(String logoutInfo);
}
