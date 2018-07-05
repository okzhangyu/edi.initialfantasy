package org.edi.initialfantasy.util;

/**
 * Created by asus on 2018/7/5.
 */
public class CharsetConvert {
    public static String convert(String str){
        try {
             str = new String(str.getBytes("GBK"),"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
        return str;
    }
}
