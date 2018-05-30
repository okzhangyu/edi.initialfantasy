package org.edi.initialfantasy.dto;

import java.util.List;

public interface IUserAuthrizationRes {

    public String getToken();
    public void setToken(String value);

    public Long getExpires();
    public void setExpires(Long value);


}
