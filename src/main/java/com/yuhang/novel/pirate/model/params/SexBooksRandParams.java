package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "随机小说黄书")
public class SexBooksRandParams {

    @ApiModelProperty(value = "偏移量")
    private int limit;

    public int getLimit() {
        return limit;
    }

    public SexBooksRandParams setLimit(int limit) {
        this.limit = limit;
        return this;
    }
}
