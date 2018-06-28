package org.edi.initialfantasy.dto;

public class UserAuthrizationResult implements IUserAuthrizationResult{

    private String token;
    private Long expires;
    @Override
    public String getToken() {
        return this.token;
    }

    @Override
    public void setToken(String value) {
        this.token = value;
    }

    @Override
    public Long getExpires() {
        return this.expires;
    }


    @Override
    public void setExpires(Long value) {
        this.expires = value;
    }

    public UserAuthrizationResult() {
    }

    public UserAuthrizationResult(String token, Long expires) {
        this.token = token;
        this.expires = expires;
    }
}
