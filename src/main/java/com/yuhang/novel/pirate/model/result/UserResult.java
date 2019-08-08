package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.UserModel;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "用户信息返回值")
public class UserResult extends BaseResult{

    private UserModel data;

    public UserModel getData() {
        return data;
    }

    public UserResult setData(UserModel data) {
        this.data = data;
        return this;
    }


}
