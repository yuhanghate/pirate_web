package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "小黄书章节")
public class SexBookChapterModel {

    @ApiModelProperty(value = "书id")
    private Integer bookId;

    @ApiModelProperty(value = "书名")
    private String bookName;

    @ApiModelProperty(value = "章节名称")
    private String chapterName;

    @ApiModelProperty(value = "章节地址")
    private String chapterUrl;

    @ApiModelProperty(value = "章节索引")
    private Integer chapterIndex;

    @ApiModelProperty(value = "章节id")
    private Integer chapterId;

    public Integer getBookId() {
        return bookId;
    }

    public SexBookChapterModel setBookId(Integer bookId) {
        this.bookId = bookId;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public SexBookChapterModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getChapterName() {
        return chapterName;
    }

    public SexBookChapterModel setChapterName(String chapterName) {
        this.chapterName = chapterName;
        return this;
    }

    public String getChapterUrl() {
        return chapterUrl;
    }

    public SexBookChapterModel setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
        return this;
    }

    public Integer getChapterIndex() {
        return chapterIndex;
    }

    public SexBookChapterModel setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
        return this;
    }

    public Integer getChapterId() {
        return chapterId;
    }

    public SexBookChapterModel setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
        return this;
    }
}
