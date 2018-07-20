package org.edi.initialfantasy.data;

import org.edi.freamwork.data.operation.OpResultCode;

/**
 * @author Fancy
 * @date 2018/7/13
 */
public class ResultCode extends OpResultCode{

    public static final String OK="0";

    public static final String FAIL="1";
    /**
     * token为空
     */
    public static final String TOKEN_IS_EMPTY = "1101";

    /**
     * token过期
     */
    public static final String TOKEN_IS_EXPIRED = "1102";

    /**
     * 无效token
     */
    public static final String TOKEN_IS_ERROR = "1103";

    /**
     * 公司不存在
     */
    public static final String COMPANY_IS_NONEXISTENT = "1104";

    /**
     * 用户不存在
     */
    public static final String USER_IS_NONEXISTENT = "1105";

    /**
     * 用户密码不正确
     */
    public static final String USERPASSWORD_IS_ERROR = "1106";


    /**
     * B1单据已生成
     */
    public static final String B1DOCENTRY_IS_EXISTENT = "1107";

    /**
     * 参数信息为空
     */
    public static final String PARAMETER_IS_NULL= "1108";

    /**
     * 条码信息为空
     */
    public static final String CODEBAR_IS_NULL= "1109";
}
