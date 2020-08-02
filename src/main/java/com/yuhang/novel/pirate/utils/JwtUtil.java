package com.yuhang.novel.pirate.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

/**
 * 用来进行签名和效验Token
 *
 * @author dgb
 * @create 2018-09-30 14:19
 **/

public class JwtUtil {

    /**
     * token 过期时间, 单位: 秒. 这个值表示 3个月
     */
    private static final long TOKEN_EXPIRED_TIME = 3 * 30 * 24 * 60 * 60;


    /**
     * 校验token是否正确
     *
     * @param token    密钥
     * @param username 用户名
     * @param secret   用户的密码
     * @return 正确: true；不正确：false
     */
    public static boolean verify(String token, String username, String secret) {
        // 根据密码生成JWT校验器
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .build();
            // 校验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        } catch (JWTVerificationException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户id
     *
     * @param token token中包含了用户名
     * @return
     */
    public static String getUid(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 生成签名
     *
     * @param username 用户名
     * @param secret   密码
     * @return 加密的TOKEN
     */
    public static String sign(String username, String secret) {

        Calendar calendar = Calendar.getInstance();

        calendar.setTime(new Date()); //需要将date数据转移到Calender对象中操作
        calendar.add(calendar.DATE, 30 * 12 * 100);//把日期往后增加n天.正数往后推,负数往前移动
        Date exp = calendar.getTime();

        // 附带用户信息
        return JWT.create()
                .withClaim("username", username)
                .withExpiresAt(exp)
                .sign(Algorithm.HMAC256(secret));
    }

}