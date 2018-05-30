package org.edi.initialfantasy.dto;

import java.util.List;

public interface IResult<T> {

    public String getCode();
    public void setCode(String value);

    public String getMessage();
    public void setMessage(String value);

    public List<T> getData();
    public void setData(List<T> value);
}
