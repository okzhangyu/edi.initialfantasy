package org.edi.initialfantasy.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Fancy
 * 数据转换
 * @date 2018/5/19
 */
public class DataConvert {
    public static String dateToStamp() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String simpleDate = simpleDateFormat.format(getNextDay(new Date()));
        Date date = simpleDateFormat.parse(simpleDate);
        long ts = date.getTime();
        String res = String.valueOf(ts);
        return res;
    }

    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, +1);//+1 今天的时间加一天
        date = calendar.getTime();
        return date;
    }

    public static Long getHalfHour() {
       Long currentTimeMillis = System.currentTimeMillis();
        Long afterHalfHourTimeMillis = currentTimeMillis+30*60*1000;
        return afterHalfHourTimeMillis;
    }
}
