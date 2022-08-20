package com.powerhair.backgroundhair.utils.util;
import org.springframework.util.DigestUtils;
import java.nio.charset.StandardCharsets;

public class MD5Util {

    /**
     * MD5加密
     *
     * @param key
     * @return
     */
    public static String encryptKey(String key){
        return DigestUtils.md5DigestAsHex(key.getBytes(StandardCharsets.UTF_8));
    }
}
