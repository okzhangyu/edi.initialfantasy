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



   /* public static final String B1DOCENTRY_IS_EXISTENT = "1101007";

    public static final String PARAMETER_IS_NULL= "1101108";

    public static final String CODEBAR_IS_NULL= "1101009";

    public static final String DOCTYPE_IS_NULL= "1101010";

    public static final String DETAIL_IS_NULL= "1101011";

    public static final String REPORTTASK_IS_EMPTY= "1101012";

    public static final String REPORT_IS_EMPTY= "1101013";

    public static final String TASK_IS_EMPTY= "1101014";

    public static final String MATERIALITEM_IS_NULL= "1101015";

    public static final String CODEBAR_IS_REPEAT= "1101016";

    public static final String STOCK_BASETYPE_IS_NULL = "1101017";

    public static final String STOCK_BASEENTRY_IS_NULL = "1101018";

    public static final String STOCK_BASELINE_IS_NULL = "1101019";

    public static final String BARCODE_ANALYSIS_IS_FAIL = "1101020";*/

}
