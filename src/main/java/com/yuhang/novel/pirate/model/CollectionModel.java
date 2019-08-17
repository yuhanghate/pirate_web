package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description = "收藏的小说")
public class CollectionModel implements Serializable {

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

    public String getBookName() {
        return bookName;
    }

    public CollectionModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getBookid() {
        return bookid;
    }

    public CollectionModel setBookid(String bookid) {
        this.bookid = bookid;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public CollectionModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public CollectionModel setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getResouceType() {
        return resouceType;
    }

    public CollectionModel setResouceType(String resouceType) {
        this.resouceType = resouceType;
        return this;
    }

}
