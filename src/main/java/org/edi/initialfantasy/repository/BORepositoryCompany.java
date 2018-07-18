package org.edi.initialfantasy.repository;

import org.edi.freamwork.exception.BusinessException;
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
        Company company =companyMapper.serchCompanyId(companyName);
        if(company==null){
            throw new BusinessException("您的公司选择有误，请重新选择！");
        }
        return company;
    }
}
