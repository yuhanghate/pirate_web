package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 唯一id
 * </p>
 *
 * @author yuhang
 * @since 2019-08-06
 */
@TableName("users")
public class UsersEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户唯一id
     */
    private String id;

    /**
     * 登陆帐号
     */
    private String username;

    /**
     * 登陆密码
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
     * 创建时间
     */
    private Date createTime;

    /**
     * 性别: 1:男 / 2:女 / 3:未选
     */
    private Integer gender;

    /**
     * 是否会员 1:是  0:否
     */
    private Integer isVip;

    public Integer getIsVip() {
        return isVip;
    }

    public UsersEntity setIsVip(Integer isVip) {
        this.isVip = isVip;
        return this;
    }

    public String getId() {
        return id;
    }

    public UsersEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UsersEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UsersEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UsersEntity setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UsersEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public UsersEntity setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public UsersEntity setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    public Integer getGender() {
        return gender;
    }

    public UsersEntity setGender(Integer gender) {
        this.gender = gender;
        return this;
    }

    @Override
    public String toString() {
        return "UsersEntity{" +
            "username=" + username +
            ", password=" + password +
            ", tel=" + tel +
            ", email=" + email +
            ", lastLoginTime=" + lastLoginTime +
            ", createTime=" + createTime +
            ", gender=" + gender +
        "}";
    }
}
