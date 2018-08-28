package org.edi.initialfantasy.dto;

public class CompanyServicePath {

    private String shortName;
    private String companyName;
    private String servicePath;

    public String getShortName(){
        return shortName;
    }

    public void setShortName(String shortName){
        this.shortName = shortName;
    }

    public String getCompanyName(){
        return companyName;
    }

    public void setCompanyName(String companyName){
        this.companyName = companyName;
    }

    public String getServicePath(){
        return servicePath;
    }

    public void setServicePath(String servicePath){
        this.servicePath = servicePath;
    }
}
