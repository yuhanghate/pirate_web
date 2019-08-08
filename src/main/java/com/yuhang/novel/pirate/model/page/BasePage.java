package com.yuhang.novel.pirate.model.page;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BasePage {

    @ApiModelProperty(value = "总条数", required = true)
    private long total;

    @ApiModelProperty(value = "每页条数", required = true)
    private long pageSize;

    @ApiModelProperty(value = "当前页数", required = true)
    private long pageNum;


    public long getTotal() {
        return total;
    }

    public BasePage setTotal(long total) {
        this.total = total;
        return this;
    }

    public long getPageSize() {
        return pageSize;
    }

    public BasePage setPageSize(long pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public long getPageNum() {
        return pageNum;
    }

    public BasePage setPageNum(long pageNum) {
        this.pageNum = pageNum;
        return this;
    }

}
