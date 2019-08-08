package com.yuhang.novel.pirate.controller;

import com.yuhang.novel.pirate.constant.UserConstant;
import com.yuhang.novel.pirate.utils.JwtUtil;

import javax.servlet.http.HttpServletRequest;

public class BaseController {

    /**
     * 获取uid
     * @param request Servlet对象
     * @return uid
     */
    public String getUid(HttpServletRequest request) {
        String token = request.getHeader(UserConstant.TOKEN);
        return JwtUtil.getUid(token);
    }
}
