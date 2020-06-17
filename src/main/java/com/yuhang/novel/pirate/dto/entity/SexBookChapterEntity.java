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
@TableName("sex_book_chapter")
public class SexBookChapterEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 书id
     */
    private Integer bookId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 章节内容地址
     */
    private String chapterUrl;

    /**
     * 章节角标排序
     */
    private Integer chapterIndex;


    /**
     * 创建日期
     */
    private LocalDateTime createTime;

    public Integer getId() {
        return id;
    }

    public SexBookChapterEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
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
    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public String getChapterUrl() {
        return chapterUrl;
    }

    public void setChapterUrl(String chapterUrl) {
        this.chapterUrl = chapterUrl;
    }
    public Integer getChapterIndex() {
        return chapterIndex;
    }

    public void setChapterIndex(Integer chapterIndex) {
        this.chapterIndex = chapterIndex;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "SexBookChapterEntity{" +
            "bookId=" + bookId +
            ", bookName=" + bookName +
            ", author=" + author +
            ", chapterName=" + chapterName +
            ", chapterUrl=" + chapterUrl +
            ", chapterIndex=" + chapterIndex +
            ", createTime=" + createTime +
        "}";
    }
}
