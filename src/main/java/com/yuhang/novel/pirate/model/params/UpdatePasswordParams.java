package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "修改密码")
public class UpdatePasswordParams {

    @ApiModelProperty(value = "邮箱", required = true)
    private String email;

    @ApiModelProperty(value = "登陆帐号", required = true)
    private String username;

    @ApiModelProperty(value = "密码", required = true)
    private String password;

    @ApiModelProperty(value = "第二次密码", required = true)
    private String againPassword;

    public String getUsername() {
        return username;
    }

    public UpdatePasswordParams setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UpdatePasswordParams setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UpdatePasswordParams setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getAgainPassword() {
        return againPassword;
    }

    public UpdatePasswordParams setAgainPassword(String againPassword) {
        this.againPassword = againPassword;
        return this;
    }
}
