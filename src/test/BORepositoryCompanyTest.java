
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.CompanyMapper;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
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
    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        return openSession;
    }

    public CompanyMapper getCompanyMapper() throws IOException {
        CompanyMapper companyMapper=getSqlSession().getMapper(CompanyMapper.class);
        return companyMapper;
    }

    /**
     * 验证公司
     * @param companyName
     * @return
     */
    public Company serchCompanyId(String companyName)throws IOException{
        Company company =getCompanyMapper().serchCompanyId(companyName);
        if(company==null){
            throw new BusinessException(ResultDescription.COMPANY_IS_NONEXISTENT);
        }
        return company;
    }
    @Test
    public void serchCompanyIdTest()throws IOException{
        Company company =serchCompanyId("北京奥维奥科技有限公司");
        System.out.println(company.toString());
    }

    @Autowired
    private IBORepositoryCompany boRepositoryCompany;

    @Test
    public void testCompanyBoRepository(){
        boRepositoryCompany.serchCompanyId("北京奥维奥科技有限公司");
    }
}
