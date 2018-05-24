package org.edi.initialfantasy.bo.department;

/**
 * @author Fancy
 * @date 2018/5/17
 */
public interface IDepartment {

    /**
     * 获取部门Id
     * @return
     */
    String getDeptId();

    /**
     * 设置部门Id值
     */
    void setDeptId(String value);

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
     * 获取公司Id
     * @return
     */
    String getCompanyId();

    /**
     * 设置公司Id
     */
    void setCompanyId(String value);
    /**
     * 获取部门名称
     * @return
     */
    String getDeptName();

    /**
     * 设置部门名称
     */
    void setDeptName(String value);

}
