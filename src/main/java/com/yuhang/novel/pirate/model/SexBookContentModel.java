package com.yuhang.novel.pirate.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "小说内容")
public class SexBookContentModel {

    @ApiModelProperty(value = "内容id")
    private int contentId;

    @ApiModelProperty(value = "小说id")
    private int bookId;

    @ApiModelProperty(value = "章节id")
    private int chapterId;

    @ApiModelProperty(value = "书名")
    private String bookName;

    @ApiModelProperty(value = "章节名称")
    private String chapterName;

    @ApiModelProperty(value = "内容")
    private String content;

    public int getContentId() {
        return contentId;
    }

    public SexBookContentModel setContentId(int contentId) {
        this.contentId = contentId;
        return this;
    }

    public int getBookId() {
        return bookId;
    }

    public SexBookContentModel setBookId(int bookId) {
        this.bookId = bookId;
        return this;
    }

    public int getChapterId() {
        return chapterId;
    }

    public SexBookContentModel setChapterId(int chapterId) {
        this.chapterId = chapterId;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public SexBookContentModel setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }

    public String getChapterName() {
        return chapterName;
    }

    public SexBookContentModel setChapterName(String chapterName) {
        this.chapterName = chapterName;
        return this;
    }

    public String getContent() {
        return content;
    }

    public SexBookContentModel setContent(String content) {
        this.content = content;
        return this;
    }
}
