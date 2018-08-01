package repository;

import org.edi.initialfantasy.data.DataConvert;
import org.edi.initialfantasy.util.UUIDUtil;
import org.junit.Test;

/**
 * Created by asus on 2018/8/1.
 */
public class testUUID {
    String token = "649d1cdaf39542b4bb23552538789e04";
    @Test
    public void testSubString(){
        String newToken = token.substring(19,32);
        System.out.println(newToken);
        String substoken = UUIDUtil.randomUUID19();
        System.out.println(substoken);
        Long time = DataConvert.getHalfHour();
        String authToken = UUIDUtil.randomUUID19()+String.valueOf(DataConvert.getHalfHour());
        System.out.println(authToken);
    }
}
