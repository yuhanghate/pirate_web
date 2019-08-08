package com.yuhang.novel.pirate.model;

/**
 * Shiro认证
 */
public class AuthorizationInfoModel {

    private String uid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    public String getUsername() {
        return username;
    }

    public AuthorizationInfoModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public AuthorizationInfoModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getUid() {
        return uid;
    }

    public AuthorizationInfoModel setUid(String uid) {
        this.uid = uid;
        return this;
    }
}
