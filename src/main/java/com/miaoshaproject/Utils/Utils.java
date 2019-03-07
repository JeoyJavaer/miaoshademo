package com.miaoshaproject.Utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * <br>〈功能简述〉<br>
 *
 * @author Administrator
 * @create 2019/3/7
 * @since 1.0.0
 */
public class Utils {


    public static String EncodeByMD5(String source) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(digest.digest(source.getBytes("utf-8")));

    }

    public static String generateOpt() {
        Random random = new Random();
        int i = random.nextInt(99999);
        i += 10000;
        return String.valueOf(i);

    }

}
