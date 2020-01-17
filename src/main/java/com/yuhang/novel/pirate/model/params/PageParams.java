package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "分页")
public class PageParams {

    @ApiModelProperty(value = "页数")
    private int pageNum;

    @ApiModelProperty(value = "每页条数")
    private int pageSize;

    public int getPageNum() {
        return pageNum;
    }

    public PageParams setPageNum(int pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public PageParams setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }
}
