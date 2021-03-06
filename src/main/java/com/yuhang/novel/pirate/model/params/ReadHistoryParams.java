package com.yuhang.novel.pirate.model.params;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "最近浏览记录参数")
public class ReadHistoryParams {

    @ApiModelProperty(value = "小说id", required = true)
    private String bookid;

    @ApiModelProperty(value = "小说章节", required = true)
    private String chapterid;

    @ApiModelProperty(value = "章节名称", required = true)
    private String chapterName;

    @ApiModelProperty(value = "小说内容", required = true)
    private String content;

    @ApiModelProperty(value = "封面", required = true)
    private String cover;

    @ApiModelProperty(value = "作者", required = true)
    private String author;

    @ApiModelProperty(value = "小说名称", required = true)
    private String bookName;

    @ApiModelProperty(value = "简介", required = true)
    private String description;

    @ApiModelProperty(value = "小说源(KS:看书神器)")
    private String resouceType;

    @ApiModelProperty(value = "快读渠道源id")
    private String tocId;

    @ApiModelProperty(value = "快读渠道源名称")
    private String tocName;

    public String getTocId() {
        return tocId;
    }

    public ReadHistoryParams setTocId(String tocId) {
        this.tocId = tocId;
        return this;
    }

    public String getTocName() {
        return tocName;
    }

    public ReadHistoryParams setTocName(String tocName) {
        this.tocName = tocName;
        return this;
    }

    public String getBookid() {
        return bookid;
    }

    public ReadHistoryParams setBookid(String bookid) {
        this.bookid = bookid;
        return this;
    }

    public String getChapterid() {
        return chapterid;
    }

    public ReadHistoryParams setChapterid(String chapterid) {
        this.chapterid = chapterid;
        return this;
    }

    public String getChapterName() {
        return chapterName;
    }

    public ReadHistoryParams setChapterName(String chapterName) {
        this.chapterName = chapterName;
        return this;
    }

    public String getContent() {
        return content;
    }

    public ReadHistoryParams setContent(String content) {
        this.content = content;
        return this;
    }

    public String getCover() {
        return cover;
    }

    public ReadHistoryParams setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public String getAuthor() {
        return author;
    }

    public ReadHistoryParams setAuthor(String author) {
        this.author = author;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public ReadHistoryParams setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ReadHistoryParams setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getResouceType() {
        return resouceType;
    }

    public ReadHistoryParams setResouceType(String resouceType) {
        this.resouceType = resouceType;
        return this;
    }
}
