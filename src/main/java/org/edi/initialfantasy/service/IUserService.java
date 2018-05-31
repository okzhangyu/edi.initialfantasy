package org.edi.initialfantasy.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.IUserAuthrizationResult;
import org.edi.initialfantasy.dto.Userauthrization;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IUserService {

    IResult<IUserAuthrizationResult> Login(Userauthrization userauthrization);
    String Logout(String logoutInfo);
}
