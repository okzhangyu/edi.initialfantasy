package org.edi.initialfantasy.repository;

import org.edi.freamwork.data.operation.OpResultCode;
import org.edi.freamwork.data.operation.OpResultDescription;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2018/7/6.
 */

@Component(value="boRepositoryCompany")
public class BORepositoryCompany implements IBORepositoryCompany {
    Logger logger = LoggerFactory.getLogger(BORepositoryCompany.class);

    @Autowired
    private CompanyMapper companyMapper;


    /**
     * 验证公司
     * @param companyName
     * @return
     */
    @Override
    public Company serchCompanyId(String companyName){
        try{
            Company company =companyMapper.serchCompanyId(companyName);
            return company;
        } catch (BusinessException e){
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            throw e;
        }catch (Exception e){
            logger.info(ResultDescription.LOGIN_EXCEPTION,e);
            throw new DBException(OpResultCode.DATABASE_OPERATE_ERROR,OpResultDescription.DATABASE_OPERATE_ERROR);
        }

    }
}
