package org.edi.initialfantasy.bo.company;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public class Company implements ICompany {


    private Integer companyId;
    private Integer parentId;
    private String companyName;
    private String shortName;

    public Integer getCompanyId() {
        return this.companyId;
    }

    public void setCompanyId(Integer value) {
        this.companyId = value;
    }

    public Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(Integer value) {
        this.parentId = value;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String value) {
        this.companyName = value;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String value) {
        this.shortName = value;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyId=" + companyId +
                ", parentId=" + parentId +
                ", companyName='" + companyName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
