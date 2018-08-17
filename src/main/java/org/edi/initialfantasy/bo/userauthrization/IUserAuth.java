package org.edi.initialfantasy.bo.userauthrization;

import org.edi.freamwork.bo.ISimpleBO;

/**
 * @author Fancy
 * 用户授权
 * @date 2018/5/17
 */
public interface IUserAuth extends ISimpleBO {
    /**
     * 获取用户Id
     * @return
     */
    String getUserId();

    /**
     * 设置用户Id
     * @param value
     */
    void setUserId(String value);

    /**
     * 获取授权类型
     * @return
     */
    String getAuthType();

    /**
     * 设置授权类型
     * @param value
     */
    void setAuthType(String value);

    /**
     * 获取授权Id
     * @return
     */
    String getAuthId();

    /**
     * 设置授权Id
     * @param value
     */
    void setAuthId(String value);

    String getAuthToken();

    void setAuthToken(String value);

    /**
     *获取有效时间（单位：s）
     * @return
     */
    Long getAuthExpires();

    /**
     * 设置有效时间（单位：s）
     * @param value
     */
    void setAuthExpires(Long value);


}
