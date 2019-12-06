package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.ConfigModel;
import com.yuhang.novel.pirate.model.UserModel;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "配置文件信息")
public class ConfigResult extends BaseResult {
    private ConfigModel data;

    public ConfigModel getData() {
        return data;
    }

    public ConfigResult setData(ConfigModel data) {
        this.data = data;
        return this;
    }
}
