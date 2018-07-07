package org.edi.initialfantasy.repository;

import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.mapper.CompanyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by asus on 2018/7/6.
 */
@Transactional
@Component(value="boRepositoryCompany")
public class BORepositoryCompany implements IBORepositoryCompany {
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public Company serchCompanyId(String companyName){
        return companyMapper.serchCompanyId(companyName);
    }
}
