package com.yuhang.novel.pirate.utils;

import java.util.Random;

public class CodeUtils {

    /**
     * 获取4位随机验证码
     * @return
     */
    public static String getValidationCode4(){
        return String.valueOf((new Random().nextInt(8999) + 1000));
    }

    /**
     * 获取6位随机验证码
     * @return
     */
    public static String getValidationCode6(){
        return String.valueOf((new Random().nextInt(899999) + 100000));
    }
}
