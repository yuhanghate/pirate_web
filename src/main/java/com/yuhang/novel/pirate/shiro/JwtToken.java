package com.yuhang.novel.pirate.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义一个对象用来封装token
 *
 * @author dgb
 * @create 2018-09-30 14:14
 **/

public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}