package org.edi.initialfantasy.dto;

import java.util.List;

public class Result<T> implements IResult<T>{

    private String code;
    private String message;
    private List<T> data;

    @Override
    public String getCode() {
        return this.code;
    }

    @Override
    public void setCode(String value) {
        this.code = value;
    }

    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public void setMessage(String value) {
        this.message = value;
    }

    @Override
    public List<T> getData() {
        return this.data;
    }

    @Override
    public void setData(List<T> value) {
        this.data = value;
    }
}
