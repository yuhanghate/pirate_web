package com.yuhang.novel.pirate.utils;

import com.yuhang.novel.pirate.shiro.JwtToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Token初始化
 */
public class TokenUtils {
    public final static String SECRET = "www.suibiankankan.com";

    public static JwtToken init(String username, String password) {
        String token = JwtUtil.sign(username, MD5Utils.getMD5String(SECRET + password));
        JwtToken jwtToken = new JwtToken(token);
        return jwtToken;
    }

    public static String getSecret(String password) {
        return MD5Utils.getMD5String(SECRET + password);
    }
}
