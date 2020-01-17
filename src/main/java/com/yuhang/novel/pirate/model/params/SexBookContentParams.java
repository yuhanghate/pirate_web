package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "小黄书章节列表")
public class SexBookContentParams {

    @ApiModelProperty(value = "章节id")
    private int chapterId;

    public int getChapterId() {
        return chapterId;
    }

    public SexBookContentParams setChapterId(int chapterId) {
        this.chapterId = chapterId;
        return this;
    }
}
