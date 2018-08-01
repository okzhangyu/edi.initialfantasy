package org.edi.initialfantasy.data;

import org.edi.freamwork.data.operation.OpResultDescription;

/**
 * @author Fancy
 * @date 2018/7/13
 */
public class ResultDescription extends OpResultDescription {

    public static final String OK = "ok";

    public static final String FAIL = "fail";


    public static final String DOCENTRY_IS_NULL = "the value of docentry is empty";

    public static final String TOKEN_IS_EMPTY = "the value of token is empty";

    public static final String TOKEN_IS_EXPIRED = "the token has expired";

    public static final String TOKEN_IS_ERROR = "the value of token is error";

    public static final String COMPANY_IS_NONEXISTENT = "the company is not existent";

    public static final String USER_IS_NONEXISTENT = "the user is not existent";

    public static final String USERNAME_OR_PASSWORD_ERROR = "用户名或密码错误";

    public static final String USERPASSWORD_IS_ERROR = "the password of user is error";

    public static final String B1DOCENTRY_IS_EXISTENT = "the bill have been generated";

    public static final String PARAMETER_IS_NULL= "the parameter info is empty";

    public static final String CODEBAR_IS_NULL= "the codebar info is empty";

    public static final String DOCTYPE_IS_NULL= "the docType info is empty";
}
