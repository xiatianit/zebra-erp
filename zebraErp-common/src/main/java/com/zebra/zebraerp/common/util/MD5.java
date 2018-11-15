package com.zebra.zebraerp.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.lang3.StringUtils;

/**
 * MD5加密工具类
 */
public class MD5 {

    public static String md5(String plainText) {
        String str;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str = buf.toString();
            return str;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        return null;
    }

    public static String md5To16byte(String plainText) {
        String str = md5(plainText);
        if (StringUtils.isNotEmpty(str)) {
            return str.substring(8, 24);
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        System.out.println(md5("ruru520"));
    }
}
