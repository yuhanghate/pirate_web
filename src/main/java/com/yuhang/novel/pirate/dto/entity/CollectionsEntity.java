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
@TableName("collections")
public class CollectionsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    /**
     * 小说名称
     */
    private String bookName;

    /**
     * 小说唯一id
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
     * 小说封面
     */
    private String conver;

    /**
     * 简介
     */
    private String description;

    /**
     * 更新状态:连载/完结
     */
    private String bookStatus;

    /**
     * 分类名称:武侠仙侠/玄幻奇幻
     */
    private String classifyName;

    /**
     * 小说源: 
KS:看书神器
     */
    private String resouceType;

    /**
     * 用户唯一id
     */
    private String uid;


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
    public String getConver() {
        return conver;
    }

    public String getDescription() {
        return description;
    }

    public CollectionsEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public CollectionsEntity setConver(String conver) {
        this.conver = conver;
        return this;
    }

    public int getId() {
        return id;
    }

    public CollectionsEntity setId(int id) {
        this.id = id;
        return this;
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

    public String getBookName() {
        return bookName;
    }

    public CollectionsEntity setBookName(String bookName) {
        this.bookName = bookName;
        return this;
    }
}
