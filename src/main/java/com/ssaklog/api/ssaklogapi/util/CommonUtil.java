package com.ssaklog.api.ssaklogapi.util;

import java.text.SimpleDateFormat;
import java.util.Optional;

public class CommonUtil {

    /**
     * 입력된 date가 입력한 pattern에 맞는 형식인지 체크
     *
     * @param date
     * @param pattern
     * @return
     */
    public static boolean checkDate(String date, String pattern) {
        if (!Optional.ofNullable(date).isPresent()) {
            return false;
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            sdf.setLenient(false);
            sdf.parse(date);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
