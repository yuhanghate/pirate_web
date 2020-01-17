package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "小黄书")
public class SexBooksModel {

    @ApiModelProperty(value = "小说id")
    private int bookId;

    @ApiModelProperty(value = "书名")
    private String bookName;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "最新章节")
    private String lastChapterName;

    @ApiModelProperty(value = "小说地址")
    private String bookUrl;

    public int getBookId() {
        return bookId;
    }

    public SexBooksModel setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public SexBooksModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public SexBooksModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SexBooksModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLastChapterName() {
        return lastChapterName;
    }

    public SexBooksModel setLastChapterName(String lastChapterName) {
        this.lastChapterName = lastChapterName;
        return this;
    }

    public String getBookUrl() {
        return bookUrl;
    }

    public SexBooksModel setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
        return this;
    }
}
