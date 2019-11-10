package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "增加权重")
public class AddSearchWeightParams {

    @ApiModelProperty(value = "书名", required = true)
    private String bookName;

    @ApiModelProperty(value = "作者", required = true)
    private String author;

    public String getBookName() {
        return bookName;
    }

    public AddSearchWeightParams setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public AddSearchWeightParams setAuthor(String author) {
        this.author = author;
        return this;
    }
}
