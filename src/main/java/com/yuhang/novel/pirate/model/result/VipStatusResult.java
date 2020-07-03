package com.yuhang.novel.pirate.model.result;

import com.yuhang.novel.pirate.model.VipModel;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "vip状态")
public class VipStatusResult extends BaseResult {
    private VipModel data;

    public VipModel getData() {
        return data;
    }

    public VipStatusResult setData(VipModel data) {
        this.data = data;
        return this;
    }
}
