package com.yuhang.novel.pirate.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 */
public class UserEntity implements Serializable {
    /**
     * 用户唯一id
     */
    private String id;


    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String tel;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 最后登陆时间
     */
    private Date lastLoginTime;

    /**
     * 登陆时间
     */
    private Date createTime;

    /**
     * 性别(预留)
     */
    private Integer gender;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public UserEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UserEntity setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public UserEntity setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UserEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UserEntity setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", tel=").append(tel);
        sb.append(", email=").append(email);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", gender=").append(gender);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}