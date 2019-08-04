package com.yuhang.novel.pirate.dao.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏表
 */
public class CollectionsEntity implements Serializable {
    private Integer id;

    /**
     * 小说名称
     */
    private String name;

    /**
     * 小说id
     */
    private String bookid;

    /**
     * 作者
     */
    private String author;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 小说状态:连载/完结
     */
    private String bookStatus;

    /**
     * 小说类型名称
     */
    private String classifyName;

    /**
     * 小说源
     */
    private String resouceType;

    /**
     * 用户id
     */
    private String uid;

    /**
     * 封面
     */
    private String conver;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBookid() {
        return bookid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
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

    public String getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(String bookStatus) {
        this.bookStatus = bookStatus;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
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

    public String getConver() {
        return conver;
    }

    public void setConver(String conver) {
        this.conver = conver;
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
        sb.append(", name=").append(name);
        sb.append(", bookid=").append(bookid);
        sb.append(", author=").append(author);
        sb.append(", createTime=").append(createTime);
        sb.append(", bookStatus=").append(bookStatus);
        sb.append(", classifyName=").append(classifyName);
        sb.append(", resouceType=").append(resouceType);
        sb.append(", uid=").append(uid);
        sb.append(", conver=").append(conver);
        sb.append(", desc=").append(desc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}