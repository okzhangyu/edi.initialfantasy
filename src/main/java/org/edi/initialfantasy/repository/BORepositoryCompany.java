package org.edi.initialfantasy.repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.edi.freamwork.bo.BusinessObjectException;
import org.edi.freamwork.data.operation.OpResultCode;
import org.edi.freamwork.data.operation.OpResultDescription;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.data.ServicePath;
import org.edi.initialfantasy.dto.CompanyServicePath;
import org.edi.initialfantasy.mapper.CompanyMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;

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

    @Override
    public List<CompanyServicePath> getCompanyInfo() {
        try {
            String path = getClass().getClassLoader().getResource(ServicePath.COMPANY_SERVICE_CONFIG).toString();
            path = path.replace("\\", "/");
            if (path.contains(":")) {
                path = path.replace("file:", "");// 2
            }
            FileInputStream inputStream = null;
            inputStream = new FileInputStream(path);
            Reader reader = new InputStreamReader(inputStream, "UTF-8");
            Gson gson = new GsonBuilder().create();
            List<CompanyServicePath> companyServicePaths = gson.fromJson(reader, List.class);
            return companyServicePaths;
        } catch (FileNotFoundException e) {
            throw new BusinessObjectException(ResultCode.COMPANY_FILE_ERROR,ResultDescription.COMPANY_FILE_NOT_FOUND);
        } catch (UnsupportedEncodingException e) {
            throw new BusinessObjectException(ResultCode.COMPANY_FILE_ERROR,ResultDescription.COMPANY_INFO_ERROR);
        }
    }


}
