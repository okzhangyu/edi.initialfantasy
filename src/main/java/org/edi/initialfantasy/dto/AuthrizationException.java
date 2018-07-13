package org.edi.initialfantasy.dto;

/**
 * @author Fancy
 * @date 2018/7/11
 * 授权异常
 */
public class AuthrizationException extends RuntimeException{
    private  String response = "无效的token";

    public String getResponse(){
        return this.response;
    }

    public AuthrizationException(){}

    public AuthrizationException(String errorMsg){
        this.response = errorMsg;
    }
}
