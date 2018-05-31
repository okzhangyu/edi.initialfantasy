package org.edi.initialfantasy.dto;

public interface IUserAuthrizationResult {

    public String getToken();
    public void setToken(String value);

    public Long getExpires();
    public void setExpires(Long value);


}
