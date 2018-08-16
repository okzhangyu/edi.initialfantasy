package org.edi.initialfantasy.bo.company;

import org.edi.freamwork.bo.ISimpleBO;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public interface ICompany extends ISimpleBO{


    /**
     * 获取公司Id
     * @return
     */
    Integer getCompanyId();

    void setCompanyId(Integer value);

    /**
     * 获父级Id
     * @return
     */
    Integer getParentId();

    /**
     * 设置父级Id
     */
    void setParentId(Integer value);

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
