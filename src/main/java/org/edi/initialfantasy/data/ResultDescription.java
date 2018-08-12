package org.edi.initialfantasy.data;

import org.edi.freamwork.data.operation.OpResultDescription;

/**
 * @author Fancy
 * @date 2018/7/13
 */
public class ResultDescription extends OpResultDescription {

    public static final String OK = "ok";

    public static final String FAIL = "fail";

    public static final String DOCENTRY_IS_NULL = "DOCENTRY信息为空";

    public static final String TOKEN_IS_EMPTY = "TOKEN信息为空";

    public static final String TOKEN_IS_EXPIRED = "TOKEN已过期";

    public static final String TOKEN_IS_ERROR = "TOKEN不存在";

    public static final String COMPANY_IS_NONEXISTENT = "公司不存在";

    public static final String USER_IS_NONEXISTENT = "用户不存在";

    public static final String USERPASSWORD_IS_ERROR = "用户密码错误";

    public static final String B1DOCENTRY_IS_EXISTENT = "单据已生成";

    public static final String PARAMETER_IS_NULL= "参数信息为空";

    public static final String CODEBAR_IS_NULL= "条码信息为空";

    public static final String DOCTYPE_IS_NULL= "[DOCTYPE]信息为空";

    public static final String DETAIL_IS_NULL= "汇报明细为空";

    public static final String REPORTTASK_IS_EMPTY= "未找到汇报库存任务";

    public static final String REPORT_IS_EMPTY= "未找到库存汇报";

    public static final String TASK_IS_EMPTY= "未找到库存任务";

    public static final String MATERIALITEM_IS_NULL= "物料条码信息为空";

    public static final String CODEBAR_IS_REPEAT= "汇报行条码信息不可重复";
}
