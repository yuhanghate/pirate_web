package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "用户信息返回值")
public class UserResultModel implements Serializable {

    @ApiModelProperty(value = "用户唯一id", required = true)
    private String id;

    @ApiModelProperty(value = "用户名", required = true)
    private String username;

    @ApiModelProperty(value = "手机号")
    private String tel;

    @ApiModelProperty(value = "邮箱")
    private String email;

    public String getId() {
        return id;
    }

    public UserResultModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserResultModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getTel() {
        return tel;
    }

    public UserResultModel setTel(String tel) {
        this.tel = tel;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResultModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
