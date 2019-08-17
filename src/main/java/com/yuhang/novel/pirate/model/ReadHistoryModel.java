package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "最近阅读记录")
public class ReadHistoryModel implements Serializable {

    @ApiModelProperty(value = "小说名称")
    private String bookName;

    @ApiModelProperty(value = "小说id")
    private String bookid;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "小说封面")
    private String cover;

    @ApiModelProperty(value = "小说源( KS:看书神器)")
    private String resouceType;

    @ApiModelProperty(value = "小说简介")
    private String description;

    public String getBookName() {
        return bookName;
    }

    public ReadHistoryModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookid() {
        return bookid;
    }

    public ReadHistoryModel setBookid(String bookid) {
        this.bookid = bookid;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ReadHistoryModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ReadHistoryModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public ReadHistoryModel setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getResouceType() {
        return resouceType;
    }

    public ReadHistoryModel setResouceType(String resouceType) {
        this.resouceType = resouceType;
        return this;
    }

}
