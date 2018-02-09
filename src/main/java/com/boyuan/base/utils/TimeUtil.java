package com.boyuan.base.utils;

import java.sql.Timestamp;

/**
 * @author jiangbo
 * @time 2018/1/17
 */
public class TimeUtil {

    public static Timestamp now(){
        return new Timestamp(System.currentTimeMillis());
    }

    public static Timestamp addHour(Timestamp time,int hour){
        return new Timestamp(time.getTime() + hour * 60 * 60 *1000);
    }
}
