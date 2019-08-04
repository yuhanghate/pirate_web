package com.yuhang.novel.pirate.utils;

import com.yuhang.novel.pirate.constant.HttpConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * 包装的返回对象
 */
public class ResultUtils {

    /**
     * 失败情况
     * @param code 返回值
     * @param msg 返回值描述
     * @return
     */
    public static Map<String, Object> toMap(int code, String msg) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", null);
        return map;
    }

    /**
     * 返回对象
     * @param code 返回值
     * @param msg 返回值描述
     * @param data 返回对象
     * @return
     */
    public static Map<String, Object> toMap(int code, String msg, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    /**
     * 返回成功对象
     * @param data 返回对象
     * @return
     */
    public static Map<String, Object> toMap(Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpConstant.HTTP_200);
        map.put("msg", "成功");
        map.put("data", data);
        return map;
    }

    /**
     * 未知异常
     * @return
     */
    public static Map<String, Object> toUnknownError() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", HttpConstant.HTTP_30000);
        map.put("msg", "未知异常");
        map.put("data", null);
        return map;
    }
}
