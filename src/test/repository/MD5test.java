package repository;

import org.edi.freamwork.cryptogram.MD5Util;
import org.junit.Test;

public class MD5test {
    @Test
    public void md5Test() throws Exception {
        String pw="123";
        String hmacPassword = MD5Util.byteArrayToHexString(MD5Util.encryptHMAC(pw.getBytes(),"avatech"));
        System.out.println(hmacPassword);
    }
}
