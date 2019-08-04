package com.yuhang.novel.pirate.utils;

import java.util.UUID;

public class UUIDUtils {

    public static String get() {
        String uuid = UUID.randomUUID().toString();	//获取UUID并转化为String对象
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
