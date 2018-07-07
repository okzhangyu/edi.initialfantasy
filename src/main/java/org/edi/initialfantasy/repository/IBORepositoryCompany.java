package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.company.Company;

/**
 * Created by asus on 2018/7/6.
 */
public interface IBORepositoryCompany {
    Company serchCompanyId(String companyName);
}
