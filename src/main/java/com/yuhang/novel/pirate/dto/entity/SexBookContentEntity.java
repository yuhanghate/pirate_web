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
@TableName("sex_book_content")
public class SexBookContentEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int contentId;
    /**
     * 小说id
     */
    private Integer bookId;

    /**
     * 章节id
     */
    private Integer chapterId;

    /**
     * 书名
     */
    private String bookName;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 章节内容地址
     */
    private String chapterUrl;

    /**
     * 内容
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    public int getContentId() {
        return contentId;
    }

    public SexBookContentEntity setContentId(int contentId) {
        this.contentId = contentId;
        return this;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
    public Integer getChapterId() {
        return chapterId;
    }

    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
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
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "SexBookContentEntity{" +
            "bookId=" + bookId +
            ", chapterId=" + chapterId +
            ", bookName=" + bookName +
            ", chapterName=" + chapterName +
            ", chapterUrl=" + chapterUrl +
            ", content=" + content +
            ", createTime=" + createTime +
        "}";
    }
}
