package org.aomr.desc.util.time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * 日期格式化工具类
 */
public class DateTimeUtil {

    public static LocalDateTime getNowDateTime() {
        return LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
    }

    public static LocalDate getNowDate() {
        return LocalDate.now(ZoneId.of("Asia/Shanghai"));
    }


    public static String getDateTimeDisplayString(LocalDateTime dateTime, String dfStr) {
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern(dfStr);
        return dtf2.format(dateTime);
    }


}
