package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.constant.HttpConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BaseResult {
    public BaseResult() {
    }

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @ApiModelProperty(value = "返回Code", required = true)
    private int code = HttpConstant.HTTP_200;

    @ApiModelProperty(value = "消息描述", required = true)
    private String msg = "成功";

    public int getCode() {
        return code;
    }

    public BaseResult setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public BaseResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }
}
