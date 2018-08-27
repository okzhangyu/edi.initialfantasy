package org.edi.initialfantasy.data;

import org.edi.freamwork.data.operation.OpResultCode;

/**
 * @author Fancy
 * @date 2018/7/13
 */
public class ResultCode extends OpResultCode{


    /**
     * token为空
     */
    public static final String TOKEN_IS_EMPTY = "1101001";

    /**
     * token过期
     */
    public static final String TOKEN_IS_EXPIRED = "1101002";

    /**
     * 无效token
     */
    public static final String TOKEN_IS_ERROR = "1101003";

    /**
     * 公司不存在
     */
    public static final String COMPANY_IS_NONEXISTENT = "1101004";

    /**
     * 用户不存在
     */
    public static final String USER_IS_NONEXISTENT = "1101005";

    /**
     * 用户密码不正确
     */
    public static final String USERPASSWORD_IS_ERROR = "1101006";


    /**
     * 公司配置文件错误
     */
    public static final String COMPANY_FILE_ERROR = "1101007";

}
