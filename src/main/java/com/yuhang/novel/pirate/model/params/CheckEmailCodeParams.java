package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "邮箱验证")
public class CheckEmailCodeParams {

    @ApiModelProperty(value = "邮箱", required = true)
    private String email;

    @ApiModelProperty(value = "用户输入的验证码", required = true)
    private String newCode;

    @ApiModelProperty(value = "邮箱发送的验证码", required = true)
    private String oldCode;

    public String getEmail() {
        return email;
    }

    public CheckEmailCodeParams setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getNewCode() {
        return newCode;
    }

    public CheckEmailCodeParams setNewCode(String newCode) {
        this.newCode = newCode;
        return this;
    }

    public String getOldCode() {
        return oldCode;
    }

    public CheckEmailCodeParams setOldCode(String oldCode) {
        this.oldCode = oldCode;
        return this;
    }
}
