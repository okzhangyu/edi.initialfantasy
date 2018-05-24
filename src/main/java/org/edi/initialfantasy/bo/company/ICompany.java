package org.edi.initialfantasy.bo.company;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public interface ICompany {

    /**
     * 获取公司Id
     * @return
     */
    String getCompanyId();

    void setCompanyId(String value);

    /**
     * 获父级Id
     * @return
     */
    String getParentId();

    /**
     * 设置父级Id
     */
    void setParentId(String value);

    /**
     * 获取公司名称
     * @return
     */
    String getCompanyName();

    /**
     * 设置公司名称
     */
    void setCompanyName(String value);

    /**
     * 获取公司简称
     * @return
     */
    String getShortName();

    /**
     * 设置公司简称
     */
    void setShortName(String value);
}
