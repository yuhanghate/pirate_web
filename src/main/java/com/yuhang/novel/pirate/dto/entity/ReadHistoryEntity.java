package com.yuhang.novel.pirate.dto.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author yuhang
 * @since 2019-08-06
 */
@TableName("read_history")
public class ReadHistoryEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 小说id
     */
    private String bookid;

    /**
     * 小说章节
     */
    private String chapterid;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 内容
     */
    private String content;

    /**
     * 封面
     */
    private String cover;

    /**
     * 作者
     */
    private String author;

    /**
     * 小说名称
     */
    private String bookName;

    /**
     * 简介
     */
    private String description;

    /**
     * 阅读时间
     */
    private Date createTime;

    /**
     * 小说源:
     */
    private String resouceType;

    /**
     * 用户唯一id
     */
    private String uid;

    /**
     * 快读渠道源id
     */
    private String tocId;

    /**
     * 快读渠道源名称
     */
    private String tocName;

    public String getTocId() {
        return tocId;
    }

    public ReadHistoryEntity setTocId(String tocId) {
        this.tocId = tocId;
        return this;
    }

    public String getTocName() {
        return tocName;
    }

    public ReadHistoryEntity setTocName(String tocName) {
        this.tocName = tocName;
        return this;
    }

    public int getId() {
        return id;
    }

    public ReadHistoryEntity setId(int id) {
        this.id = id;
        return this;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }
    public String getChapterid() {
        return chapterid;
    }

    public void setChapterid(String chapterid) {
        this.chapterid = chapterid;
    }
    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
    public String getContent() {
        return content;
    }

    public String getCover() {
        return cover;
    }

    public ReadHistoryEntity setCover(String cover) {
        this.cover = cover;
        return this;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    public String getResouceType() {
        return resouceType;
    }

    public void setResouceType(String resouceType) {
        this.resouceType = resouceType;
    }
    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getDescription() {
        return description;
    }

    public ReadHistoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }

}
