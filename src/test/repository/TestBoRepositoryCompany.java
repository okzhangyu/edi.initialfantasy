package repository;

import junit.framework.TestCase;
import org.edi.freamwork.cryptogram.MD5Util;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.dto.CompanyServicePath;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
import org.edi.initialfantasy.repository.IBORepositoryUser;
import org.edi.initialfantasy.repository.IBORepositoryUserAuth;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author Fancy
 * @date 2018/7/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBoRepositoryCompany extends TestCase{

    @Autowired
    private IBORepositoryCompany boRepositoryCompany;
    @Autowired
    private IBORepositoryUser boRepositoryUser;
    @Autowired
    private IBORepositoryUserAuth boRepositoryUserAuth;

    private String companyName = "北京奥维奥科技有限公司";

    @Test
    public void testSerchCompanyId(){
        Company company = boRepositoryCompany.serchCompanyId(companyName);
        Assert.assertEquals(companyName,company.getCompanyName());
    }

    @Test
    public void testSerchUser(){
        //User user = boRepositoryUser.getUserByToken("84503ac6434a448d99cc1535174927000");

        List<CompanyServicePath> companyServicePathList = boRepositoryCompany.getCompanyInfo();
        String companyStr = companyServicePathList.toString();
        Assert.assertEquals(1,companyServicePathList.size());
        // Assert.assertEquals("84503ac6434a448d99cc1535174927000",user.get());
    }

    @Test
    public void testMD5()throws Exception{
        String password = "1";
        String md5Password =MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(password.getBytes(),"avatech"));
        System.out.println("-------------------");
        System.out.println(md5Password);
    }
}
