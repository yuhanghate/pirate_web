package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "作者作者书籍")
public class AuthorBooksModel {

    @ApiModelProperty(value = "书名")
    private String bookName;

    @ApiModelProperty(value = "作者")
    private String author;

    @ApiModelProperty(value = "封面")
    private String cover;

    @ApiModelProperty(value = "看书id")
    private int bookKsId;

    @ApiModelProperty(value = "看书神器 1:是  2:否")
    private int typeKs;

    @ApiModelProperty(value = "快读类型 1:是  2:否")
    private int typeKd;

    @ApiModelProperty(value = "快读id")
    private String bookKdId;

    public String getBookName() {
        return bookName;
    }

    public AuthorBooksModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public AuthorBooksModel setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public AuthorBooksModel setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public int getBookKsId() {
        return bookKsId;
    }

    public AuthorBooksModel setBookKsId(int bookKsId) {
        this.bookKsId = bookKsId;
        return this;
    }

    public int getTypeKs() {
        return typeKs;
    }

    public AuthorBooksModel setTypeKs(int typeKs) {
        this.typeKs = typeKs;
        return this;
    }

    public int getTypeKd() {
        return typeKd;
    }

    public AuthorBooksModel setTypeKd(int typeKd) {
        this.typeKd = typeKd;
        return this;
    }

    public String getBookKdId() {
        return bookKdId;
    }

    public AuthorBooksModel setBookKdId(String bookKdId) {
        this.bookKdId = bookKdId;
        return this;
    }
}
