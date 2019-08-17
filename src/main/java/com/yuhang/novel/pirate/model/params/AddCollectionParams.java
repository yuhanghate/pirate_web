package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "添加收藏")
public class AddCollectionParams {

    @ApiModelProperty(value = "小说名称", required = true)
    private String bookName;

    @ApiModelProperty(value = "小说id", required = true)
    private String bookid;

    @ApiModelProperty(value = "作者" ,required = true)
    private String author;

    @ApiModelProperty(value = "小说封面", required = true)
    private String cover;

    @ApiModelProperty(value = "简介", required = true)
    private String description;

    @ApiModelProperty(value = "更新状态:连载/完结", required = true)
    private String bookStatus;

    @ApiModelProperty(value = "分类名称:武侠仙侠/玄幻奇幻", required = true)
    private String classifyName;

    @ApiModelProperty(value = "小说源(KS:看书神器)")
    private String resouceType;


    public String getBookid() {
        return bookid;
    }

    public AddCollectionParams setBookid(String bookid) {
        this.bookid = bookid;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public AddCollectionParams setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public AddCollectionParams setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getBookStatus() {
        return bookStatus;
    }

    public AddCollectionParams setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
        return this;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public AddCollectionParams setClassifyName(String classifyName) {
        this.classifyName = classifyName;
        return this;
    }

    public String getResouceType() {
        return resouceType;
    }

    public AddCollectionParams setResouceType(String resouceType) {
        this.resouceType = resouceType;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public AddCollectionParams setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public AddCollectionParams setDescription(String description) {
        this.description = description;
        return this;
    }
}
