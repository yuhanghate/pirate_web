package com.yuhang.novel.pirate.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 阅读记录
 */
public class ReadHistoryEntity implements Serializable {
    private Integer id;

    /**
     * 小说id
     */
    private String bookid;

    /**
     * 章节id
     */
    private String chapterid;

    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 小说源类型
     */
    private String resouceType;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 章节名称
     */
    private String chapterName;

    /**
     * 小说内容
     */
    private String content;

    /**
     * 封面
     */
    private String conver;

    /**
     * 小说名称
     */
    private String bookName;

    /**
     * 简介
     */
    private String desc;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getConver() {
        return conver;
    }

    public void setConver(String conver) {
        this.conver = conver;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", bookid=").append(bookid);
        sb.append(", chapterid=").append(chapterid);
        sb.append(", author=").append(author);
        sb.append(", createTime=").append(createTime);
        sb.append(", resouceType=").append(resouceType);
        sb.append(", uid=").append(uid);
        sb.append(", chapterName=").append(chapterName);
        sb.append(", content=").append(content);
        sb.append(", conver=").append(conver);
        sb.append(", bookName=").append(bookName);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}