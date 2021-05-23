package com.example.firstapp.ui.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {
    static final public String PRINT_FORMAT= "HH:mm";

    /**
     *
     * @param sec
     * @return the time of the day (given PRINT_FORMAT)
     */
    static public String fromEpochToString(Long sec){
        return (new SimpleDateFormat(TimeUtil.PRINT_FORMAT)).format(new Date(sec*1000));
    }
}
