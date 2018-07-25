package org.edi.initialfantasy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.freamwork.exception.BusinessException;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.data.ResultDescription;
import org.edi.initialfantasy.mapper.UserMapper;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by asus on 2018/7/25.
 */
public class BORepositoryUserTest {
    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        return openSession;
    }

    public UserMapper getUserMapper() throws IOException {
        UserMapper userMapper=getSqlSession().getMapper(UserMapper.class);
        return userMapper;
    }


    /**
     * 账户密码查询用户
     * @param account
     * @param password
     * @return
     */
    public User getUserBySelect(String account, String password) throws IOException{
        return getUserMapper().getUserBySelect(account,password);
    }


    /**
     * 账户公司查询用户
     * @param account
     * @param companyId
     * @return
     */
    public User getUserByCompanyId(String account,Integer companyId)throws IOException{
        User user = getUserMapper().getUserByCompanyId(account,companyId);
        if(user==null){
            throw new BusinessException(ResultDescription.USER_IS_NONEXISTENT);
        }
        return user;
    }

    /**
     * 名字查询用户
     * @param account
     * @return
     */
    public User getUserByName(String account)throws IOException{
        return getUserMapper().getUserByName(account);
    }

    @Test
    public void getUserBySelectTest()throws IOException{
         User user = getUserBySelect("admin","1q2w3e");
        System.out.println(user.toString());
    }

    @Test
    public void getUserByCompanyIdTest()throws IOException{
        User user = getUserByCompanyId("admin",1);
        System.out.println(user.toString());
    }

    @Test
    public void getUserByNameTest()throws IOException{
        User user = getUserByName("admin");
        System.out.println(user.toString());
    }
}
