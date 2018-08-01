package repository;

import junit.framework.TestCase;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Fancy
 * @date 2018/7/30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class TestBoRepositoryCompany extends TestCase{

    @Autowired
    private IBORepositoryCompany boRepositoryCompany;

    private String companyName = "北京奥维奥科技有限公司";

    @Test
    public void testSerchCompanyId(){
        Company company = boRepositoryCompany.serchCompanyId(companyName);
        Assert.assertEquals(companyName,company.getCompanyName());
    }
}
