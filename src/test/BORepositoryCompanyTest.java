
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.CompanyMapper;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by asus on 2018/7/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class BORepositoryCompanyTest {

    @Autowired
    private IBORepositoryCompany boRepositoryCompany;

    private final static String companyName = "北京奥维奥科技有限公司";
    @Test
    public void testCompanyBoRepository(){
        Company company = boRepositoryCompany.serchCompanyId(companyName);
        Assert.assertEquals(companyName,company.getCompanyName());
    }
}
