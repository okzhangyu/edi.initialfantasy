package org.edi.initialfantasy.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.IUserAuthrizationResult;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IUserService {
    IResult<IUserAuthrizationResult> Login(String companyName,String userName,String password);
    IResult Logout(String token);
}
