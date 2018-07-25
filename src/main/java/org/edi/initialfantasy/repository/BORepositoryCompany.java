package org.edi.initialfantasy.repository;

import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.data.ResultDescription;
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


    /**
     * 验证公司
     * @param companyName
     * @return
     */
    @Override
    public Company serchCompanyId(String companyName){
        Company company =companyMapper.serchCompanyId(companyName);
        if(company==null){
            throw new BusinessException(ResultDescription.COMPANY_IS_NONEXISTENT);
        }
        return company;
    }
}
