package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.dto.CompanyServicePath;
import org.edi.initialfantasy.service.CompanyService;

import java.util.List;

/**
 * Created by asus on 2018/7/6.
 */
public interface IBORepositoryCompany {

    Company serchCompanyId(String companyName);

    List<CompanyServicePath> getCompanyInfo();
}
