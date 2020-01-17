package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "小黄书章节列表")
public class SexBookChapterParams {

    @ApiModelProperty(value = "小说id")
    private int bookId;

    public int getBookId() {
        return bookId;
    }

    public SexBookChapterParams setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }
}
