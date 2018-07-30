package org.edi.initialfantasy.data;

import org.edi.freamwork.data.operation.OpResultDescription;

/**
 * @author Fancy
 * @date 2018/7/13
 */
public class ResultDescription extends OpResultDescription {

    public static final String OK = "ok";

    public static final String FAIL = "fail";


    public static String TOKEN_IS_EMPTY = "the value of token is empty";

    public static String TOKEN_IS_EXPIRED = "the token has expired";

    public static String TOKEN_IS_ERROR = "the value of token is error";

    public static  String COMPANY_IS_NONEXISTENT = "the company is not existent";

    public static  String USER_IS_NONEXISTENT = "the user is not existent";

    public static  String USERPASSWORD_IS_ERROR = "the password of user is error";

    public static  String B1DOCENTRY_IS_EXISTENT = "the bill have been generated";

    public static  String PARAMETER_IS_NULL= "the parameter info is null";

    public static  String CODEBAR_IS_NULL= "the codebar info is null";

    public static  String DOCENTRY_IS_NULL= "the docEntry info is null";

    public static  String DOCTYPE_IS_NULL= "the docType info is null";
}
