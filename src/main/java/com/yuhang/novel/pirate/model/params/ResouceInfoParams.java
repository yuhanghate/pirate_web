package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "获取源")
public class ResouceInfoParams {

    @ApiModelProperty(value = "类型(0:热度排序 1:权重排序) ", notes = "默认按热度排序", required = false)
    private int type = 0;

    @ApiModelProperty(value = "页数", required = true)
    private int pageNum;

    @ApiModelProperty(value = "每页条数", notes = "默认20条")
    private int pageSize = 20;

    public int getType() {
        return type;
    }

    public ResouceInfoParams setType(int type) {
        this.type = type;
        return this;
    }

    public int getPageNum() {
        return pageNum;
    }

    public ResouceInfoParams setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public ResouceInfoParams setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
