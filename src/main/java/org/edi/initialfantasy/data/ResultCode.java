package org.edi.initialfantasy.data;

import org.edi.freamwork.data.operation.OpResultCode;

/**
 * @author Fancy
 * @date 2018/7/13
 */
public class ResultCode extends OpResultCode{

    public static final String OK="ok";

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


}
