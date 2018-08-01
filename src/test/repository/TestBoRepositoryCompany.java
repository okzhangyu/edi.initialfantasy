package repository;

import junit.framework.TestCase;
import org.edi.initialfantasy.bo.company.Company;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.repository.IBORepositoryCompany;
import org.edi.initialfantasy.repository.IBORepositoryUser;
import org.edi.initialfantasy.repository.IBORepositoryUserAuth;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
    public void testGetUserBySelect(){
        User user = boRepositoryUser.getUserBySelect("admin","1q2w3e");
        System.out.println(user.toString());
        Assert.assertEquals(user.getUserName(),"Jayson Butler");
    }



    @Test
    public void testGetUserByCompanyId(){
        User user = boRepositoryUser.getUserByCompanyId("admin",1);
        System.out.println(user.toString());
        Assert.assertEquals(user.getCompanyId().toString(),"1");
    }

    @Test
    public void testGetUserByName(){
        User user = boRepositoryUser.getUserByName("admin");
        System.out.println(user.toString());
        Assert.assertEquals(user.getMobilePassword(),"1q2w3e");
    }

    @Test
    public void testSerchLoginRecord(){
        UserAuth userAuth = boRepositoryUserAuth.serchLoginRecord("Jayson Butler");
        System.out.println(userAuth.getUserId());
        Assert.assertEquals(userAuth.getAuthType(),"客户");
    }

    @Test
    public void testUpdateAuthExpires() throws Exception{
        UserAuth userAuth = new UserAuth();
        userAuth.setAuthId("userone");
        userAuth.setUserId("Workflow");
        long dataStamp = Long.parseLong(DataConvert.dateToStamp());
        userAuth.setAuthExpires(dataStamp);
        boRepositoryUserAuth.updateAuthExpires(userAuth);
        UserAuth user = boRepositoryUserAuth.serchLoginRecord("Workflow");
        Assert.assertEquals(user.getAuthExpires().toString(),String.valueOf(dataStamp));

    }


    @Test
    public void testUpdateActive(){
        UserAuth userAuth = new UserAuth();
        userAuth.setAuthId("userone");
        userAuth.setUserId("Workflow");
        userAuth.setIsActive("Y");
        userAuth.setAuthToken("");
        boRepositoryUserAuth.updateActive(userAuth);
        UserAuth user = boRepositoryUserAuth.serchLoginRecord("Workflow");
        Assert.assertEquals(user.getIsActive().trim(),"Y");
    }



    @Test
    public void testSerchAuthByToken(){
        UserAuth userAuth = boRepositoryUserAuth.serchAuthByToken("5b228c0b460d43588606fb43bf34e3d9");
        Assert.assertEquals(userAuth.getAuthId(),"userone");
    }








}
