package org.edi.initialfantasy.service;

import org.edi.initialfantasy.dto.IResult;
import org.edi.initialfantasy.dto.IUserAuthrizationResult;
import org.edi.initialfantasy.dto.Userauthrization;

/**
 * @author Fancy
 * @date 2018/5/25
 */
public interface IUserService {

    /**
     * 登陆授权
     * @param userauthrization 授权信息
     * @return 登陆结果
     */
    IResult<IUserAuthrizationResult> login(Userauthrization userauthrization);

    /**
     * 退出
     * @param token token
     * @return 退出结果
     */
    IResult logout(String token);
}
