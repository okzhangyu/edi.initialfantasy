package org.edi.initialfantasy.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.edi.initialfantasy.bo.user.User;
import org.edi.initialfantasy.bo.userauthrization.UserAuth;
import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.dto.UserAuthrizationResult;
import org.edi.initialfantasy.mapper.UserAuthMapper;
import org.edi.initialfantasy.util.UUIDUtil;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by asus on 2018/7/25.
 */
public class BORepositoryUserAuthTest {
    public SqlSession getSqlSession() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession openSession = sqlSessionFactory.openSession(true);
        return openSession;
    }

    public UserAuthMapper getUserAuthMapper() throws IOException {
        UserAuthMapper userAuthMapper=getSqlSession().getMapper(UserAuthMapper.class);
        return userAuthMapper;
    }

    /**
     * 保存用户登陆记录
     * @param userAuth
     * @return
     */
    public void saveLoginRecord(UserAuth userAuth)throws IOException{
        getUserAuthMapper().saveLoginRecord(userAuth);
    }

    /**
     * 查询用户登陆记录
     * @param userName
     * @return
     */
    public UserAuth serchLoginRecord(String userName)throws IOException{
        return getUserAuthMapper().serchLoginRecord(userName);
    }

    /**
     * 更新时间戳
     * @param userAuth
     * @return
     */
    public void updateAuthExpires(UserAuth userAuth)throws IOException{
        getUserAuthMapper().updateAuthExpires(userAuth);
    }

    /**
     * 用户登陆激活
     * @param userAuth
     * @return
     */
    public void updateActive(UserAuth userAuth)throws IOException{
        getUserAuthMapper().updateActive(userAuth);
    }

    /**
     * 查询用户权限
     * @param token
     * @return
     */
    public UserAuth serchAuthByToken(String token)throws IOException{
        return getUserAuthMapper().serchAuthByToken(token);
    }

    /**
     * 处理用户登录记录
     * @param user
     * @param NextDayTimeMillis
     * @return
     */
    public UserAuthrizationResult processUserLoginRecord(User user, long NextDayTimeMillis)throws IOException{
        UserAuthrizationResult uaResult = new UserAuthrizationResult();
        //查询用户历史登录记录
        UserAuth userRecord = getUserAuthMapper().serchLoginRecord(user.getUserName());
        if(userRecord==null) {
            //没有用户记录则新建
            String authToken = UUIDUtil.randomUUID32();
            userRecord = new UserAuth(user.getUserName(), user.getIsMobileUser(), "客户", authToken, NextDayTimeMillis, "Y");
            getUserAuthMapper().saveLoginRecord(userRecord);
            uaResult = new UserAuthrizationResult(authToken,NextDayTimeMillis);
        }else{
            //存在用户记录则得到当前登录时间的时间戳，和记录时间戳进行比对，在有效期内则返回，否则更新
            Long currentTimeMillis = System.currentTimeMillis();
            if(currentTimeMillis<userRecord.getAuthExpires()){
                uaResult = new UserAuthrizationResult(userRecord.getAuthToken(),userRecord.getAuthExpires());
            }else{
                UserAuth userAuth = new UserAuth(userRecord.getUserId(),NextDayTimeMillis);
                getUserAuthMapper().updateAuthExpires(userAuth);
                uaResult = new UserAuthrizationResult(userRecord.getAuthToken(),NextDayTimeMillis);
            }
            UserAuth uauth = new UserAuth(userRecord.getUserId(),"Y");
            getUserAuthMapper().updateActive(uauth);
        }
        return  uaResult;
    }


    @Test
    public void saveLoginRecordTest() throws Exception{
        UserAuth userAuth = new  UserAuth("yellow", "jackson", "客户", UUIDUtil.randomUUID32(), Long.parseLong(DataConvert.dateToStamp()) , "Y");
        saveLoginRecord(userAuth);
    }


    @Test
    public void serchLoginRecordTest() throws Exception{
        UserAuth userAuth = serchLoginRecord("yellow");
        System.out.println(userAuth.toString());
    }

    @Test
    public void updateAuthExpiresTest() throws Exception{
        UserAuth userAuth = new  UserAuth("yellow", "jackson", "客户", UUIDUtil.randomUUID32(), Long.parseLong(DataConvert.dateToStamp()) , "Y");
        updateAuthExpires(userAuth);
    }

    @Test
    public void updateActiveTest() throws Exception{
        UserAuth userAuth = new  UserAuth("yellow", "jackson", "客户", UUIDUtil.randomUUID32(), Long.parseLong(DataConvert.dateToStamp()) , "Y");
        updateActive(userAuth);
    }


    @Test
    public void serchAuthByTokenTest() throws Exception{
        UserAuth userAuth = serchAuthByToken("7c10904bebc149cab359ace09f17aca4");
        System.out.println(userAuth.toString());
    }

    @Test
    public void processUserLoginRecordTest() throws Exception{
        User user = new User(1,"Jayson Butler","A9782133F16812CDAA2CC36AAA68F189BC6B8DFD","admin","1q2w3e",1);
        processUserLoginRecord(user,Long.parseLong(DataConvert.dateToStamp()));
    }
}
