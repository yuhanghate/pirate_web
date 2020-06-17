package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-12-24
 */
@TableName("sex_books")
public class SexBooksEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 简介
     */
    private String description;

    /**
     * 最后章节
     */
    private String lastChapterName;

    /**
     * 小说地址
     */
    private String bookUrl;

    /**
     * 网站当前页地址
     */
    private String pageUrl;

    /**
     * 创建时间
     */
    private LocalDateTime createAt;

    /**
     * 1:删除  0:不删除
     */
    private Integer deleteFlag;

    public int getId() {
        return id;
    }

    public SexBooksEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getLastChapterName() {
        return lastChapterName;
    }

    public void setLastChapterName(String lastChapterName) {
        this.lastChapterName = lastChapterName;
    }
    public String getBookUrl() {
        return bookUrl;
    }

    public void setBookUrl(String bookUrl) {
        this.bookUrl = bookUrl;
    }
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "SexBooksEntity{" +
            "bookName=" + bookName +
            ", author=" + author +
            ", description=" + description +
            ", lastChapterName=" + lastChapterName +
            ", bookUrl=" + bookUrl +
            ", pageUrl=" + pageUrl +
            ", createAt=" + createAt +
            ", deleteFlag=" + deleteFlag +
        "}";
    }
}
