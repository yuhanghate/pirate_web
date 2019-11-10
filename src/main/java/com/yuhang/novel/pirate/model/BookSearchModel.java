package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "搜索")
public class BookSearchModel {


    @ApiModelProperty(value = "书名")
    private String bookName;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "简介")
    private String description;

    @ApiModelProperty(value = "章节名称")
    private String lastChapterName;

    @ApiModelProperty(value = "连载/完结")
    private String resouceType;

    @ApiModelProperty(value = "看书id")
    private int bookKsId;

    @ApiModelProperty(value = "书类型")
    private String kind;


    @ApiModelProperty(value = "看书神器 1:是  2:否")
    private int typeKs;

    @ApiModelProperty(value = "快读类型 1:是  2:否")
    private int typeKd;

    @ApiModelProperty(value = "快读id")
    private String bookKdId;

    public String getBookName() {
        return bookName;
    }

    public BookSearchModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public BookSearchModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public BookSearchModel setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public BookSearchModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getLastChapterName() {
        return lastChapterName;
    }

    public BookSearchModel setLastChapterName(String lastChapterName) {
        this.lastChapterName = lastChapterName;
        return this;
    }

    public String getResouceType() {
        return resouceType;
    }

    public BookSearchModel setResouceType(String resouceType) {
        this.resouceType = resouceType;
        return this;
    }

    public int getBookKsId() {
        return bookKsId;
    }

    public BookSearchModel setBookKsId(int bookKsId) {
        this.bookKsId = bookKsId;
        return this;
    }

    public String getKind() {
        return kind;
    }

    public BookSearchModel setKind(String kind) {
        this.kind = kind;
        return this;
    }

    public int getTypeKs() {
        return typeKs;
    }

    public BookSearchModel setTypeKs(int typeKs) {
        this.typeKs = typeKs;
        return this;
    }

    public int getTypeKd() {
        return typeKd;
    }

    public BookSearchModel setTypeKd(int typeKd) {
        this.typeKd = typeKd;
        return this;
    }

    public String getBookKdId() {
        return bookKdId;
    }

    public BookSearchModel setBookKdId(String bookKdId) {
        this.bookKdId = bookKdId;
        return this;
    }
}
