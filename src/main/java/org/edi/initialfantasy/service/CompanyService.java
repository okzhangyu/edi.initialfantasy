package org.edi.initialfantasy.service;

import org.edi.freamwork.data.IResult;
import org.edi.freamwork.data.Result;
import org.edi.freamwork.exception.BusinessException;
import org.edi.freamwork.exception.DBException;
import org.edi.initialfantasy.data.ResultCode;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.dto.CompanyServicePath;
import org.edi.initialfantasy.dto.UserAuthrizationResult;
import org.edi.initialfantasy.repository.BORepositoryCompany;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/v1")
public class CompanyService implements ICompanyService {


    @Autowired
    private BORepositoryCompany boRepositoryCompany;

    @GET
    @Override
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/companies")
    public IResult<CompanyServicePath> getCompanyInfo() {
        Result rs ;
        List<CompanyServicePath> listResult = new ArrayList<CompanyServicePath>();
        try {
            List<CompanyServicePath> companyServicePaths = boRepositoryCompany.getCompanyInfo();
            rs = new Result(ResultCode.SUCCESS, ResultDescription.OK, companyServicePaths);
        }catch (BusinessException e){
            rs = new Result(e);
        }catch (Exception e){
            e.printStackTrace();
            rs = new Result(ResultCode.FAIL, e);
        }
        return rs;
    }


}
