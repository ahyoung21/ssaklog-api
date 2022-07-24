package com.ssaklog.api.ssaklogapi.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Optional;

public class CommonUtil {

    private static final String SALT = "SHA1PRNG"; // TODO : 따로 관리 필요

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

    /**
     * sha-512 암호화 리턴
     *
     * @param text
     * @return
     */
    public static String getSha512(String text) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update((text + salt()).getBytes(StandardCharsets.UTF_8));
            return new String(Base64.getEncoder().encode(md.digest()));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 암호화에 사용할 salt 값 랜덤 생성
     *
     * @return
     */
    public static String salt() {
        String salt = "";
        try {
            SecureRandom random = SecureRandom.getInstance(SALT);
            byte[] bytes = new byte[16];
            random.nextBytes(bytes);
            salt = new String(Base64.getEncoder().encode(bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return salt;
    }
}
