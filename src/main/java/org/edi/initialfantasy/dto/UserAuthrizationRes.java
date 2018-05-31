package org.edi.initialfantasy.dto;

public class UserAuthrizationRes implements IUserAuthrizationRes{

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
        return null;
    }

    @Override
    public void setExpires(Long value) {
        this.expires = value;
    }
}
