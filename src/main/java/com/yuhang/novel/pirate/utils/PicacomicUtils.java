package com.yuhang.novel.pirate.utils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class PicacomicUtils {

    public static final String HOST = "picaapi.picacomic.com";
    public static final String USER_AGENT = "okhttp/3.8.1";

    private static final String secretKey = "~d}$Q7$eIni=V)9\\RK/P.RM4;9[7|@/CA}b~OW!3?EV`:<>M7pddUBL5n|0/*Cn";
    private static final String apiKey = "C69BAF41DA5ABD1FFEDC6D2FEA56B";
    private static final String appVersion = "2.2.1.3.3.4";
    private static final String appChannel = "1";
    private static final String buildVersion = "45";
    private static final String accept = "application/vnd.picacomic.com.v1+json";
    private static final String appPlatform = "android";
    private static final String appUUID = UUID.randomUUID().toString();
    private static final String quality = "original";
    private static final String nonce = UUID.randomUUID().toString().replace("-", "");

    private static final HMACSHA256 hmacsha256 = new HMACSHA256(secretKey.getBytes(StandardCharsets.UTF_8));


    public static void main(String[] args) {
        String httpMethod = "POST";
        String targetUri = "/auth/sign-in";
        long time = System.currentTimeMillis();
        String currentTime = String.valueOf(time / 1000);
        String temp = targetUri.substring(1) + currentTime + nonce + httpMethod + apiKey;
        String signature = hmacsha256.encode(temp.toLowerCase().getBytes(StandardCharsets.UTF_8));

        System.out.println("api-key:"+apiKey);
        System.out.println("app-version:"+appVersion);
        System.out.println("app-channel:"+appChannel);
        System.out.println("app-build-version:"+buildVersion);
        System.out.println("accept:"+accept);
        System.out.println("app-platform:"+appPlatform);
        System.out.println("app-uuid:"+appUUID);
        System.out.println("Host:"+HOST);
        System.out.println("image-quality:"+quality);
        System.out.println("nonce:"+nonce);
        System.out.println("time:"+currentTime);
        System.out.println("signature:"+signature);
        System.out.println("User-Agent:"+USER_AGENT);
    }


}
